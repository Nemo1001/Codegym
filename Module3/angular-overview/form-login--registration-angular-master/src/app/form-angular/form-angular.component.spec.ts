import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAngularComponent } from './form-angular.component';

describe('FormAngularComponent', () => {
  let component: FormAngularComponent;
  let fixture: ComponentFixture<FormAngularComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormAngularComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAngularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
