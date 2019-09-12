import { Component, OnInit } from '@angular/core';
import {Book} from '../book';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {BookService} from '../Book.service';

@Component({
  selector: 'app-detail-books',
  templateUrl: './detail-books.component.html',
  styleUrls: ['./detail-books.component.scss']
})
export class DetailBooksComponent implements OnInit {
  message: string;
  book: Book;

  constructor(private route: ActivatedRoute, private bookService: BookService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe((param: ParamMap) => {
      const id = parseInt(param.get('id'), 10);
      this.bookService.getDetail(id).subscribe(next => {
        this.book = next;
      }, error => {
        this.message = 'Cannot retrieve customer detail. Reason: ' + error;
      });
    });
  }
}
