import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CcsubjectComponent } from './ccsubject.component';

describe('CcsubjectComponent', () => {
  let component: CcsubjectComponent;
  let fixture: ComponentFixture<CcsubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CcsubjectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CcsubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
