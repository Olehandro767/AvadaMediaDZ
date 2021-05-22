import { Component } from '@angular/core';
import { mainHostForFiles, movieURL } from '../commonConstants';
import { IBack } from '../interfaces/IBack';
import { IInputMode } from '../interfaces/IInputMode';
import { AjaxService } from '../service/ajax.service';
import { MessageService } from '../service/message.service';
import { SeoBlockService } from '../service/seo-block-service.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css'],
  providers: [AjaxService, MessageService]
})
export class MoviesComponent implements IInputMode, IBack {

  public inputMode: boolean = false
  public title: string = 'Movies'
  public imagesForMoviesMainPage: Array<Array<string>> = []
  public imagesForSoonMoviesMainPage: Array<Array<string>> = []
  public mainImage: string = ''
  public images: Array<string> = []
  private mainImageFile: File = null
  private imageFiles: Array<File> = []

  constructor(private ajax: AjaxService, private messageService: MessageService) {
    if (!this.inputMode) this.getCurrentMovies()
  }

  public openInpunMode(): void {
    this.mainImage = ''
    this.images = []
    this.mainImageFile = null
    this.imageFiles = []
    this.inputMode = true
    window.scrollTo(0, 0);
  }

  public closeInpunMode(): void {
    this.getCurrentMovies()
    this.inputMode = false
    window.scrollTo(0, 0);
  }

  public back(): void {
    this.closeInpunMode()
  }

  private getCurrentMovies() {
    this.ajax.get(`${movieURL}/getAllMovies`).subscribe(
      data => {
        this.imagesForMoviesMainPage = []
        for (const [key, value] of Object.entries(data)) {
          let movieArr: Array<string> = [
            value['id'],                                          // 0
            value['name'],                                        // 1
            value['description'],                                 // 2
            `${mainHostForFiles}/${value['path_to_main_image']}`, // 3
            value['path_to_top_banner_image'],                    // 4
            value['seo_block']                                    // 5
          ]
          this.imagesForMoviesMainPage.push(movieArr)
        }
      },
      error => { }
    )
  }

  public openPhoto(event: any, index: number): void {
    if (event.target.files) {
      let render = new FileReader()
      let file: File = event.target.files[0]
      // let formData = new FormData()
      // formData.append('file', event.target.files[0], `${}.${event.target.files[0].name}`)
      if (index != -1) {
        render.onload = e => this.images.push(e.target.result as string)
        this.imageFiles.push(file)
      }
      else {
        render.onload = e => this.mainImage = e.target.result as string
        this.mainImageFile = file
      }
      render.readAsDataURL(event.target.files[0])
    } else this.messageService.open('/assets/pngwing.com.png', 'Can\'t open image')
  }

  public removePhoto(index: number): void {
    if (index != -1) this.images[index] = null
    else this.mainImage = ''
  }

  private addNewMovie(
    nameInput: string,
    descriptionTextarea: string,
    // linkInput: string,
    // twoD: boolean,
    // threeD: boolean,
    // imax: boolean,
    seoResponse
  ) {
    let filteredImageFiles: Array<File> = []
    this.imageFiles.forEach(elem => {
      if (elem != null) filteredImageFiles.push(elem)
    })

    let formDataMainImage = new FormData()
    formDataMainImage.append('file', this.mainImageFile, `${nameInput}_main_${this.mainImageFile.name}`)
    this.ajax.getHttpClient().post(`${movieURL}/addPhoto`, formDataMainImage, { observe: 'response' }).subscribe(
      data => {
        if (data['body']) {
          if (filteredImageFiles.length != 0) {
            let index: number = 0;
            filteredImageFiles.forEach(elem => {
              ++index
              let formData = new FormData()
              formData.append('file', elem, `${nameInput}_${index}_${elem.name}`)
              this.ajax.getHttpClient().post(`${movieURL}/addPhoto`, formData, { observe: 'response' }).subscribe(
                body => { },
                error => {
                  this.messageService.open('/assets/pngwing.com.png', `Problems with gallery of photo (index: ${index})`)
                }
              )
            })
            while (index < filteredImageFiles.length) {
              console.log(`${index} : ${filteredImageFiles.length}`)
            }
          }
          let body = {
            name: nameInput,
            description: descriptionTextarea,
            // link: linkInput,
            // twoD: twoD,
            // threeD: threeD,
            // imax: imax,
            seoBlockId: null
          }
          body.seoBlockId = (seoResponse != null) ? seoResponse : -1
          this.ajax.post(`${movieURL}/addNewMovie`, body).subscribe(
            data => {
              this.messageService.openNotify('/assets/pngarea.com_check-mark-icon-472478.png', this.messageService.getDictionary()[2], 'Good request')
              this.closeInpunMode()
            },
            error => {
              this.messageService.open('/assets/pngwing.com.png', 'Can\'t send data')
            }
          )
        }
      },
      error => {
        this.messageService.open('/assets/pngwing.com.png', 'Problems with request main photo')
      }
    )
  }

  public submit(
    nameInput: string,
    descriptionTextarea: string,
    // linkInput: string,
    // woD: boolean,
    // threeD: boolean,
    // imax: boolean
  ) {
    if (nameInput != '' && this.mainImage != '') {
      let seoBlockTemp = SeoBlockService.seoBlock
      if (seoBlockTemp.isValidate()) {
        seoBlockTemp.createRequest().subscribe(
          data => {
            console.log(JSON.stringify(data))
            this.addNewMovie(
              nameInput,
              descriptionTextarea,
              // linkInput, 
              // twoD, 
              // threeD, 
              // imax, 
              data
            )
          },
          error => {
            this.messageService.open('/assets/pngwing.com.png', 'Problems with request SEO Block')
          }
        )
      } else this.addNewMovie(
        nameInput,
        descriptionTextarea,
        // linkInput, 
        // twoD, 
        // threeD, 
        // imax, 
        null
      )
    } else this.messageService.open('/assets/pngwing.com.png', 'Please, write movie name and other info')
  }

}