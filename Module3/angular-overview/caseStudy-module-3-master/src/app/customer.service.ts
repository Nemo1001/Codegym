import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from './Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  getList(): Observable<Customer[]> {
    const url = `${this.apiUrl}/customers/`;
    return this.http.get<Customer[]>(url);
  }

  getDetail(id: number): Observable<Customer> {
    const url = `${this.apiUrl}/customers/${id}`;
    return this.http.get<Customer>(url);
  }

  add(customer: Customer) {
    const url = this.apiUrl + '/customers/';
    return this.http.post(url, customer);
  }

  delete(id: number) {
    const url = this.apiUrl + '/customers/' + id;
    return this.http.delete(url);
  }

  edit(id: number , customer: Customer): Observable<Customer> {
    const url = this.apiUrl + '/customers/' + id;
    return this.http.put<Customer>(url, customer);
  }

}
