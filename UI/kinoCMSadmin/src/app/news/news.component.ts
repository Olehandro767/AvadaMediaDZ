import { Component, OnInit } from '@angular/core';
import { IBack } from '../interfaces/IBack';
import { AjaxService } from '../service/ajax.service';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  // styleUrls: ['./news.component.css']
  providers: [AjaxService, MessageService]
})
export class NewsComponent implements OnInit, IBack {

  public tempNewsState: boolean = true

  public inputMode: boolean = !false
  public title: string = 'News'
  public imagesForCinemasMainPage: Array<Array<string>> = []

  public checkboxText: string = ''

  constructor(private ajax: AjaxService, private messageService: MessageService) { }

  ngOnInit() {
    this.checkboxSwitch(this.tempNewsState)
  }

  public back() { }

  public checkboxSwitch(state: boolean) {
    if (state) 
      this.checkboxText = 'Enable news'
    else 
      this.checkboxText = 'Disable news'
  }

}
