import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserloginComponent} from './userlogin/userlogin.component';
import {RegisterComponent} from './register/register.component';
import {CustomerManagementComponent} from './customer-management/customer-management.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';

const routes: Routes = [
  {path: 'login', component: UserloginComponent},
  {path: 'customer-management', component: CustomerManagementComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'create-customer', component: CreateCustomerComponent},
  {path: 'edit/:id', component: EditCustomerComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
