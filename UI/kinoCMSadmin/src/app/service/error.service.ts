import { Injectable } from '@angular/core';
import { ErrorComponent } from '../error/error.component';

@Injectable({
  providedIn: 'root'
})
export class ErrorService {

  private static errorComponent: ErrorComponent = null

  public setErrorComponent(errorComponent: ErrorComponent) {
    ErrorService.errorComponent = errorComponent
  }

  public open(imgPath: string, message: string) {
    ErrorService.errorComponent.open()
    ErrorService.errorComponent.imgPath = imgPath
    ErrorService.errorComponent.message = message
  }

}
