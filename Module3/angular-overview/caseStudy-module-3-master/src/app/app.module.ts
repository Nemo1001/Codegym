import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {UserloginComponent} from './userlogin/userlogin.component';
import {RegisterComponent} from './register/register.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import {HttpClientModule} from '@angular/common/http';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';


@NgModule({
  declarations: [
    AppComponent,
    UserloginComponent,

    RegisterComponent,
    CustomerManagementComponent,
    CreateCustomerComponent,
    EditCustomerComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
