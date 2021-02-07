import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseCoordinatorRoutingModule } from './course-coordinator-routing.module';
import { CchomeComponent } from './cc-home/cchome.component';
import { CcfacultyComponent } from './cc-faculty/ccfaculty.component';
import { CcstudentComponent } from './cc-student/ccstudent.component';
import { CcnoticeComponent } from './cc-notice/ccnotice.component';
import { CcsubjectComponent } from './cc-subject/ccsubject.component';
import { CcscheduleComponent } from './cc-schedule/ccschedule.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';
import { CreateStudentComponent } from '../shared/components/Student/create-student/create-student.component';


@NgModule({
  declarations: [CchomeComponent, CcfacultyComponent, CcstudentComponent, CcnoticeComponent, CcsubjectComponent, CcscheduleComponent],
  imports: [
    CommonModule,
    CourseCoordinatorRoutingModule,
    FormsModule,
    SharedModule
  ],
  exports:[
    CchomeComponent,
    CcfacultyComponent,
    CcstudentComponent,
    CcnoticeComponent,
    CcsubjectComponent,
    CcscheduleComponent
  ],
  bootstrap:[
    CchomeComponent,
    CcfacultyComponent,
    CcstudentComponent,
    CcnoticeComponent,
    CcsubjectComponent,
    CcscheduleComponent
  ],
  entryComponents:[CreateStudentComponent],
})
export class CourseCoordinatorModule { }
