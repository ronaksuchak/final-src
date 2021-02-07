import { MatDialogModule } from '@angular/material/dialog';
import { CreateStudentComponent } from './shared/components/Student/create-student/create-student.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationModule } from './authentication/authentication.module';
import { CourseCoordinatorModule } from './course-coordinator/course-coordinator.module';
import { FacultyModule } from './faculty/faculty.module';
import { StudentModule } from './student/student.module';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AssignmentService } from './shared/services/assignment.service';
import { DataService } from './shared/services/data.service';
import { FacultyService } from './shared/services/faculty.service';
import { NotesService } from './shared/services/notes.service';
import { NoticeService } from './shared/services/notice.service';
import { ScheduleService } from './shared/services/schedule.service';
import { StudentService } from './shared/services/student.service';
import { SubjectService } from './shared/services/subject.service';
import { AppErrorHandler } from './shared/errors/app-error-handler';
import { ErrorHandler } from '@angular/core';
import { AuthenticationService } from './shared/services/authentication.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import {  MatTableModule } from '@angular/material/table';
import {  MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatButtonModule } from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { MatSortModule } from '@angular/material/sort';
import {MatInputModule} from '@angular/material/input'
import { MatFormFieldModule } from '@angular/material/form-field';
import { CcAuthGuardService } from './shared/services/cc-auth-guard.service';
import { AuthGuardService } from './shared/services/auth-guard.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    AuthenticationModule,
    CourseCoordinatorModule,
    FacultyModule,
    StudentModule,
    SharedModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    SlickCarouselModule,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatInputModule,
    CommonModule,
    MatFormFieldModule,
    MatSortModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatDialogModule
    
  ],
  providers: [
    AssignmentService,
    CcAuthGuardService,
    AuthGuardService,
    FacultyService,
    NotesService,
    NoticeService,
    ScheduleService,
    StudentService,
    SubjectService,
    AuthenticationService,
    { provide: ErrorHandler, useClass: AppErrorHandler}
  ],
  bootstrap: [AppComponent]
  

})
export class AppModule { }
