import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormAngularComponent } from './form-angular/form-angular.component';
import {ReactiveFormsModule} from '@angular/forms';
import { RegisterFinalComponent } from './register-final/register-final.component';

@NgModule({
  declarations: [
    AppComponent,
    FormAngularComponent,
    RegisterFinalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
