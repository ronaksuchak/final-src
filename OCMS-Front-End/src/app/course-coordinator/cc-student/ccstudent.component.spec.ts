import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CcstudentComponent } from './ccstudent.component';

describe('CcstudentComponent', () => {
  let component: CcstudentComponent;
  let fixture: ComponentFixture<CcstudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CcstudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CcstudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
