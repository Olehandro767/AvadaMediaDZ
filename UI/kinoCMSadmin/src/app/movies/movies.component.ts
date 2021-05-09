import { Component } from '@angular/core';
import { mainHost, movieURL, seoBlockURL } from '../commonConstants';
import { AjaxService } from '../service/ajax.service';
import { MessageService } from '../service/message.service';
import { SeoBlockService } from '../service/seo-block-service.service';
import { SessionService } from '../service/session.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css'],
  providers: [AjaxService, MessageService]
})
export class MoviesComponent {

  public inputMode: boolean = true
  public title: string = 'Movies'
  public mainImage: string = ''
  public images: Array<string> = []

  private mainImageFile: File = null
  private imageFiles: Array<File> = []

  constructor(private ajax: AjaxService, private messageService: MessageService) { }

  public openInpunMode(): void {
    this.inputMode = true
    window.scrollTo(0, 0);
  }

  public closeInpunMode(): void {
    this.inputMode = false
    window.scrollTo(0, 0);
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

  private addNewMovie(nameInput: string, descriptionTextarea: string, linkInput: string, twoD: boolean, threeD: boolean, imax: boolean, seoResponse) {
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
              while ((index) <= filteredImageFiles.length) { 
                console.log(`${index} : ${filteredImageFiles.length}`)
              }
            }
            let body = {
              name: nameInput,
              description: descriptionTextarea,
              link: linkInput,
              twoD: twoD,
              threeD: threeD,
              imax: imax,
              seoBlockId: null
            }
            body.seoBlockId = (seoResponse != null) ? seoResponse : -1
            this.ajax.post(`${movieURL}/addNewMovie`, body).subscribe(
              data => {
                this.messageService.openNotify('/assets/pngarea.com_check-mark-icon-472478.png', this.messageService.getDictionary()[2], 'Good request')
                this.inputMode = !this.inputMode
              },
              error => {
                this.messageService.open('/assets/pngwing.com.png', 'Can\t send data')
              }
            )
          }
        },
        error => {
          this.messageService.open('/assets/pngwing.com.png', 'Problems with request main photo')
        }
      )
  }

  public submit(nameInput: string, descriptionTextarea: string, linkInput: string, twoD: boolean, threeD: boolean, imax: boolean) {
    if (nameInput != '' && this.mainImage != '') {
      let seoBlockTemp = SeoBlockService.seoBlock
      if (seoBlockTemp.isValidate()) {
        seoBlockTemp.createRequest().subscribe(
          data => {
            console.log(JSON.stringify(data))
            this.addNewMovie(nameInput, descriptionTextarea, linkInput, twoD, threeD, imax, data)
          },
          error => {
            this.messageService.open('/assets/pngwing.com.png', 'Problems with request SEO Block')
          }
        )
      } else this.addNewMovie(nameInput, descriptionTextarea, linkInput, twoD, threeD, imax, null)
    } else this.messageService.open('/assets/pngwing.com.png', 'Please, write movie name and other info')
  }

}