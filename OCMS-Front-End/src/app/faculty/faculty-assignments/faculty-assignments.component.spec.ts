import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacultyAssignmentsComponent } from './faculty-assignments.component';

describe('FacultyAssignmentsComponent', () => {
  let component: FacultyAssignmentsComponent;
  let fixture: ComponentFixture<FacultyAssignmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacultyAssignmentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacultyAssignmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
