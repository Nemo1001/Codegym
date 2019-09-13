import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersInfoComponent } from './customers-info.component';

describe('CustomersInfoComponent', () => {
  let component: CustomersInfoComponent;
  let fixture: ComponentFixture<CustomersInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomersInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomersInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
