import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CcfacultyComponent } from './ccfaculty.component';

describe('CcfacultyComponent', () => {
  let component: CcfacultyComponent;
  let fixture: ComponentFixture<CcfacultyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CcfacultyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CcfacultyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
