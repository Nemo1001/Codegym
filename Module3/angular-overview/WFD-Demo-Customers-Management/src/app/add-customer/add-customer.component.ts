import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.scss']
})
export class AddCustomerComponent implements OnInit {
  message: string;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
  }

  addCustomer(customerForm) {
    console.log(customerForm.value);

    this.customerService.add(customerForm.value).subscribe( () => {
      this.message = 'Successfully added!';
    }, error => {
      this.message = 'Error when adding customer!';
    });
  }

}
