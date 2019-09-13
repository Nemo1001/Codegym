import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaculatorComponent } from './caculator.component';

describe('CaculatorComponent', () => {
  let component: CaculatorComponent;
  let fixture: ComponentFixture<CaculatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaculatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
