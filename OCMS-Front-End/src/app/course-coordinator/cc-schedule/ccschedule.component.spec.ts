import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CcscheduleComponent } from './ccschedule.component';

describe('CcscheduleComponent', () => {
  let component: CcscheduleComponent;
  let fixture: ComponentFixture<CcscheduleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CcscheduleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CcscheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
