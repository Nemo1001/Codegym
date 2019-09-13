import {Component, Input, OnInit} from '@angular/core';
import {CustomerService} from '../customer.service';
import {Customer} from '../Customer';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.scss']
})
export class EditCustomerComponent implements OnInit {
  message: string;
  customer: Customer;
  constructor(private customerService: CustomerService, private routes: ActivatedRoute, private  router: Router) { }

  ngOnInit() {
    this.routes.paramMap.subscribe((param: ParamMap) => {
      const id = parseInt(param.get('id'), 10);
      this.customerService.getDetail(id).subscribe(next => {
        this.customer = next;
      }, error => {
        this.message = 'can not retrieve customer detail. ' + error;
      });
    });
  }

  editCustomer(customerForm) {
    this.customerService.edit(this.customer.id, customerForm.value).subscribe(next => {
      this.message = 'update successful';
    }, error => {
      this.message = 'update fail!';
    });
  }
  backCM() {
    this.router.navigate(['customer-management']);
  }
}
