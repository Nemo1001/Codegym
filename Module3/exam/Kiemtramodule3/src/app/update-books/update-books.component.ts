import {Component, Input, OnInit} from '@angular/core';
import {BookService} from '../Book.service';
import {Book} from '../book';
import {ActivatedRoute, ParamMap} from '@angular/router';

@Component({
  selector: 'app-update-books',
  templateUrl: './update-books.component.html',
  styleUrls: ['./update-books.component.scss']
})
export class UpdateBooksComponent implements OnInit {

  message: string;
  book: Book;

  constructor(private bookService: BookService, private routes: ActivatedRoute) {
  }

  ngOnInit() {
    this.routes.paramMap.subscribe((param: ParamMap) => {
      const id = parseInt(param.get('id'), 10);
      this.bookService.getDetail(id).subscribe(next => {
        this.book = next;
        this.message = 'show book detail successful';
      }, error => {
        this.message = 'can not retrieve book detail. ' + error;
      });
    });
  }
  edit(bookForm) {
    this.bookService.edit(this.book.id, bookForm.value).subscribe(next => {
      this.message = 'update successful';
    }, error => {
      this.message = 'update fail!';
    });
  }
}

