import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { StudentHomeComponent } from './student-home/student-home.component';
import { StudentSubjectsComponent } from './student-subjects/student-subjects.component';
import { StudentScheduleComponent } from './student-schedule/student-schedule.component';
import { StudentAssignmentsComponent } from './student-assignments/student-assignments.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';
import { AuthenticationModule } from '../authentication/authentication.module';
import { FacultyModule } from '../faculty/faculty.module';
import { CourseCoordinatorModule } from '../course-coordinator/course-coordinator.module';


@NgModule({
  declarations: [StudentHomeComponent, StudentSubjectsComponent, StudentScheduleComponent, StudentAssignmentsComponent],
  imports: [
    CommonModule,
    StudentRoutingModule,
    FormsModule,
    AuthenticationModule,
    FacultyModule,
    CourseCoordinatorModule,
    SharedModule
  ],
  exports:[
    StudentHomeComponent,
    StudentSubjectsComponent,
    StudentScheduleComponent,
    StudentAssignmentsComponent
  ]
})
export class StudentModule { }
