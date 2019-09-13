import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';

@Component({
  selector: 'app-customers-info',
  templateUrl: './customers-info.component.html',
  styleUrls: ['./customers-info.component.scss']
})
export class CustomersInfoComponent implements OnInit {
  selectedCustomer: Customer;

  selectHandler($event) {
    this.selectedCustomer = $event;
  }
  constructor() { }

  ngOnInit() {
  }

}
