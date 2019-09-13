import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomersInfoComponent} from './customers-info/customers-info.component';
import {AddCustomerComponent} from './add-customer/add-customer.component';


const routes: Routes = [
  {
    path: '', component: CustomersInfoComponent
  },
  {
    path: 'add', component: AddCustomerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
