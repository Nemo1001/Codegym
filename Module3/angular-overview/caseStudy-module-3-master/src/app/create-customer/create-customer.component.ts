import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.scss']
})
export class CreateCustomerComponent implements OnInit {
  message: string;
  constructor(private customerService: CustomerService) { }

  ngOnInit() {
  }
  createCustomer(customerForm) {
    this.customerService.add(customerForm.value).subscribe( () => {
      this.message = 'Successfully created';
    }, error => {
      this.message = 'Error when creating customer';
    });
  }
}
