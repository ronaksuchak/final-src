import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacultySubjectsComponent } from './faculty-subjects.component';

describe('FacultySubjectsComponent', () => {
  let component: FacultySubjectsComponent;
  let fixture: ComponentFixture<FacultySubjectsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacultySubjectsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacultySubjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
