import { Injectable } from '@angular/core';
import { Customer } from './customer';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  apiUrl = environment.apiUrl;

  constructor(private httpClient: HttpClient) {

  }

  getListRealtime(): Observable<Customer[]> {
    const url = `${this.apiUrl}/customers`;
    return this.httpClient.get<Customer[]>(url);
  }

  getDetail(id: number): Observable<Customer> {
    const url = `${this.apiUrl}/customers/${id}`;
    return this.httpClient.get<Customer>(url);
  }

  add(customer: Customer) {
    const url = this.apiUrl + '/customers';
    return this.httpClient.post(url, customer);
  }

  delete(id: number) {
    const url = this.apiUrl + '/customers/' + id;
    return this.httpClient.delete(url);
  }

  // Đang lỗi cors! Ai sửa giúp!
  edit(id: number, customer: Customer): Observable<any> {
    const url = this.apiUrl + '/customers/' + id;
    return this.httpClient.put(url, customer);
  }
}
