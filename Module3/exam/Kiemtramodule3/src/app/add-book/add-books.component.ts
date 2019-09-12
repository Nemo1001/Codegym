import { Component, OnInit } from '@angular/core';
import {BookService} from '../Book.service';

@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.scss']
})
export class AddBooksComponent implements OnInit {
  message: string;

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
  }

  createBook(bookForm) {

    this.bookService.add(bookForm.value).subscribe(() => {

      this.message = 'successfully created';
    }, error => {
      this.message = 'Fail Created';
    });
  }
}

