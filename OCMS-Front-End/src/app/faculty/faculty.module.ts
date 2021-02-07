import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacultyRoutingModule } from './faculty-routing.module';
import { FacultyHomeComponent } from './faculty-home/faculty-home.component';
import { FacultySubjectsComponent } from './faculty-subjects/faculty-subjects.component';
import { FacultyAssignmentsComponent } from './faculty-assignments/faculty-assignments.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';
import { StudentModule } from '../student/student.module';


@NgModule({
  declarations: [FacultyHomeComponent, FacultySubjectsComponent, FacultyAssignmentsComponent],
  imports: [
    CommonModule,
    FacultyRoutingModule,
    FormsModule,
    SharedModule
  ],
  exports:[
    FacultyHomeComponent,
    FacultySubjectsComponent,
    FacultyAssignmentsComponent
  ],
})
export class FacultyModule { }
