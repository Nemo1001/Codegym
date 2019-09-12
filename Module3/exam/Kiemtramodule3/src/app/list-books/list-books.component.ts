import {Component, Input, OnInit} from '@angular/core';
import {Book} from '../book';
import {BookService} from '../Book.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.scss']
})
export class ListBooksComponent implements OnInit {
  books: Book[];
  @Input() book: Book;
  message: string;
  constructor(private bookService: BookService,
              private router: Router) { }

  ngOnInit() {
    this.getListBook();
  }
  getListBook() {
    const updateBook = this.bookService.getList();
    updateBook.subscribe(newList => {
      this.books = newList;
    }, error => {
      console.log('error');
      this.message = error.message;
    });
  }
  deleteBook(id: number) {
    this.bookService.delete(id).subscribe(() => {
      this.message = 'Successfully deleted';
      this.getListBook();
    }, error => {
      this.message = 'Failed when deleting book with id = ' + id;
    });
  }
  editBook(id: number) {
    this.router.navigate(['/edit', id]);
  }
  detailBook(id: number) {
    this.router.navigate(['/detail', id]);
  }

}
