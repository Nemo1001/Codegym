import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListBooksComponent } from './list-books/list-books.component';
import { UpdateBooksComponent } from './update-books/update-books.component';
import { DetailBooksComponent } from './detail-books/detail-books.component';
import { AddBooksComponent } from './add-book/add-books.component';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ListBooksComponent,
    UpdateBooksComponent,
    DetailBooksComponent,
    AddBooksComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
   ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
