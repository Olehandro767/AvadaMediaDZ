import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BannersComponent } from './banners/banners.component';
import { MoviesComponent } from './movies/movies.component';
import { CinemasComponent } from './cinemas/cinemas.component';
import { NewsComponent } from './news/news.component';
import { StocksComponent } from './stocks/stocks.component';
import { PagesComponent } from './pages/pages.component';
import { UsersComponent } from './users/users.component';
import { MailingComponent } from './mailing/mailing.component';
import { HttpClientModule } from '@angular/common/http';
import { ErrorComponent } from './error/error.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    BannersComponent,
    MoviesComponent,
    CinemasComponent,
    NewsComponent,
    StocksComponent,
    PagesComponent,
    UsersComponent,
    MailingComponent,
    ErrorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
