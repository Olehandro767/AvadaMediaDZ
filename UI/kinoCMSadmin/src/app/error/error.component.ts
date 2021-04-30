import { Component } from '@angular/core';
import { ErrorService } from '../service/error.service';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent {

  public idState4MainContainer: Array<string> = ['main_container_close', 'main_container']

  public isOpen: boolean = false
  public imgPath: string = ''
  public mainContainer: string = this.idState4MainContainer[0]
  public message: string = ''

  constructor(private errorService: ErrorService) {
    this.errorService.setErrorComponent(this)
  }

  public close() {
    this.mainContainer = this.idState4MainContainer[0]
      setTimeout(() => {
        this.isOpen = false
      }, 400);
  }

  public autoClose() {
    setTimeout(() => this.close(), 5000);
  }

  public open() {
    this.isOpen = true
    this.mainContainer = this.idState4MainContainer[1]
    this.autoClose()
  }

}
