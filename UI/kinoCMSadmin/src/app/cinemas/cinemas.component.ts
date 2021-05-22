import { Component } from '@angular/core';
import { cinemasURL } from '../commonConstants';
import { IBack } from '../interfaces/IBack';
import { IInputMode } from '../interfaces/IInputMode';
import { AjaxService } from '../service/ajax.service';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-cinemas',
  templateUrl: './cinemas.component.html',
  // styleUrls: ['./cinemas.component.css']
  providers: [AjaxService, MessageService]
})
export class CinemasComponent implements IInputMode, IBack {

  public inputMode: boolean = false
  public title: string = 'Cinemas'
  public infoForCinemasMainPage: Array<Array<string>> = []
  public logoImage: string = ''
  private logoImageFile: File = null
  public topBannerImage: string = ''
  private topBannerImageFile: File = null
  public images: Array<string> = []
  private imageFiles: Array<File> = []

  constructor(private ajax: AjaxService, private messageService: MessageService) {
    if (!this.inputMode) this.getCurrentCinemas()
  }

  getCurrentCinemas() {
    this.ajax.get(`${cinemasURL}/getAll`).subscribe(
      data => { },
      error => { }
    )
  }

  public openInpunMode(): void {
    this.inputMode = true
  }

  public closeInpunMode(): void {
    this.inputMode = false
  }

  back(): void {
    this.closeInpunMode()
  }

  public openPhoto(event: any, index: number): void {
    if (event.target.files) {
      let render = new FileReader()
      let file: File = event.target.files[0]
      if (index == -2) { // logo
        render.onload = e => this.logoImage = e.target.result as string
        this.logoImageFile = file
      }
      else if (index == -1) { // top banner
        render.onload = e => this.topBannerImage = e.target.result as string
        this.topBannerImageFile = file
      }
      else { // gallery
        render.onload = e => this.images.push(e.target.result as string)
        this.imageFiles.push(file)
      }
      render.readAsDataURL(event.target.files[0])
    } else this.messageService.open('/assets/pngwing.com.png', 'Can\'t open image')
  }

  public removePhoto(index: number): void {
    if (index == -2) this.logoImage = ''
    else if (index == -1) this.topBannerImage = ''
    else this.images[index] = null
  }

  public submit(
    nameInput: string,
    descriptionTextarea: string,
    aboutCinemaTextarea: string,
    conditionsTextarea: string
  ) {
  }

}