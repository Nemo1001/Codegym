import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListBooksComponent} from './list-books/list-books.component';
import {AddBooksComponent} from './add-book/add-books.component';
import {UpdateBooksComponent} from './update-books/update-books.component';
import {DetailBooksComponent} from './detail-books/detail-books.component';


const routes: Routes = [
  {path: 'listBook', component: ListBooksComponent},
  {path: 'createBook', component: AddBooksComponent},
  {path: 'edit/:id', component: UpdateBooksComponent},
  {path: 'detail/:id', component: DetailBooksComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
