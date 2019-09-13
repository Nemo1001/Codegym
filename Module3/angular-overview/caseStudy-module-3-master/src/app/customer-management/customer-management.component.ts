import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../Customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html',
  styleUrls: ['./customer-management.component.scss']
})
export class CustomerManagementComponent implements OnInit {
  customers: Customer[];
  @Input() customer: Customer;
  message: string;

  constructor(private customerService: CustomerService, private router: Router) {
  }

  ngOnInit() {
    this.getListCustomer();
  }

  getListCustomer() {
    const updateCustomer = this.customerService.getList();
    updateCustomer.subscribe(newList => {
      this.customers = newList;
    }, error => {
      console.log('error');
      this.message = error.message;
    });
  }
  editCustomer(id: number) {
    this.router.navigate(['/edit', id]);
  }

  deleteCustomer(id: number) {
    this.customerService.delete(id).subscribe(() => {
      this.message = 'Successfully deleted';
      this.getListCustomer();
    }, error => {
      this.message = 'Failed when deleting customer with id = ' + id;
    });
  }
}
