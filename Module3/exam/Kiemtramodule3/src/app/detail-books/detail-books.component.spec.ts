import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailBooksComponent } from './detail-books.component';

describe('DetailBooksComponent', () => {
  let component: DetailBooksComponent;
  let fixture: ComponentFixture<DetailBooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailBooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
