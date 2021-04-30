import { Component } from '@angular/core';
import { mainHost, movieURL } from '../commonConstants';
import { AjaxService } from '../service/ajax.service';
import { ErrorService } from '../service/error.service';
import { SessionService } from '../service/session.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css'],
  providers: [AjaxService, ErrorService]
})
export class MoviesComponent {

  public inputMode: boolean = true
  public title: string = 'Movies'
  public mainImage: string = ''
  public images: Array<string> = []

  private mainImageFile: File = null
  private imageFiles: Array<File> = []

  constructor(private ajax: AjaxService, private errorService: ErrorService) { }

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
    } else this.errorService.open('/assets/pngwing.com.png', 'Can\'t open image')
  }

  public removePhoto(index: number): void {
    if (index != -1) this.images[index] = null
    else this.mainImage = ''
  }

  public submit(nameInput: string, descriptionTextarea: string, linkInput: string, twoD: boolean, threeD: boolean, imax: boolean) {
    if (nameInput != '' && this.mainImage != '') {
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
                this.ajax.getHttpClient().post(`${movieURL}/addPhoto`, formData, { observe : 'response' }).subscribe(
                  body => {},
                  error => {}
                )
              })
            } else {
            }
          }
        },
        error => { }
      )
    } else this.errorService.open('/assets/pngwing.com.png', 'Please, write movie name and other info')
  }

}