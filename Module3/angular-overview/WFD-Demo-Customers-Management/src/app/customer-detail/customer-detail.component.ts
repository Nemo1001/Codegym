import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';
import {filterStackTrace} from 'protractor/built/util';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.scss']
})
export class CustomerDetailComponent implements OnInit {

  @Input() customer: Customer;
  message: string;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
  }

  editCustomer(customerForm) {

    const id = customerForm.value.id;

    // const firstName = customerForm.value.firstName;
    // const lastName = customerForm.value.lastName;

    // destructuring assignment
    const { firstName, lastName } = customerForm.value;
    const customer = {
      firstName,
      lastName
    };

    this.customerService.edit(id, customer).subscribe( () => {
      this.message = 'Successfully updated';
    }, error => {
      this.message = 'Failed when updating customer';
    });
  }

}
