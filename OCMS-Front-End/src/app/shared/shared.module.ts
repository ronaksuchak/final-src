import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { StudentListComponent } from './components/Student/student-list/student-list.component';
import { StudentDetailsComponent } from './components/Student/student-details/student-details.component';
import { UpdateStudentComponent } from './components/Student/update-student/update-student.component';
import { CreateStudentComponent } from './components/Student/create-student/create-student.component';
import { FacultyListComponent } from './components/Faculty/faculty-list/faculty-list.component';
import { FacultyDetailsComponent } from './components/Faculty/faculty-details/faculty-details.component';
import { UpdateFacultyComponent } from './components/Faculty/update-faculty/update-faculty.component';
import { CreateFacultyComponent } from './components/Faculty/create-faculty/create-faculty.component';
import { SubjectListComponent } from './components/Subject/subject-list/subject-list.component';
import { SubjectDetailsComponent } from './components/Subject/subject-details/subject-details.component';
import { NoticeListComponent } from './components/Notice/notice-list/notice-list.component';
import { UploadNoticeComponent } from './components/Notice/upload-notice/upload-notice.component';
import { ScheduleListComponent } from './components/Schedule/schedule-list/schedule-list.component';
import { ScheduleDetailsComponent } from './components/Schedule/schedule-details/schedule-details.component';
import { CreateScheduleComponent } from './components/Schedule/create-schedule/create-schedule.component';
import { AssignmentListComponent } from './components/Assignment/assignment-list/assignment-list.component';
import { UploadAssignmentComponent } from './components/Assignment/upload-assignment/upload-assignment.component';
import { NotesListComponent } from './components/Notes/notes-list/notes-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { FacultyModule } from '../faculty/faculty.module';
import { StudentModule } from '../student/student.module';
import {MatSortModule} from '@angular/material/sort';
import {MatIconModule} from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import {MatDialog, MatDialogConfig, MatDialogModule} from '@angular/material/dialog';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatToolbarModule } from '@angular/material/toolbar';


@NgModule({
  declarations: [
    StudentListComponent,
    StudentDetailsComponent,
    UpdateStudentComponent,
    CreateStudentComponent,
    FacultyListComponent,
    FacultyDetailsComponent,
    UpdateFacultyComponent,
    CreateFacultyComponent,
    SubjectListComponent,
    SubjectDetailsComponent,
    NoticeListComponent,
    UploadNoticeComponent,
    ScheduleListComponent,
    ScheduleDetailsComponent,
    CreateScheduleComponent,
    AssignmentListComponent,
    UploadAssignmentComponent,
    NotesListComponent,
    NavbarComponent,
    FooterComponent,
    
  ],
  imports: [
    CommonModule,
    SharedRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    FormsModule,
    MatPaginatorModule,
    MatTableModule,
    MatTooltipModule,
    MatToolbarModule,
    MatSortModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    
  ],
  exports:[
    StudentListComponent,
    StudentDetailsComponent,
    UpdateStudentComponent,
    CreateStudentComponent,
    FacultyListComponent,
    FacultyDetailsComponent,
    UpdateFacultyComponent,
    CreateFacultyComponent,
    SubjectListComponent,
    SubjectDetailsComponent,
    NoticeListComponent,
    UploadNoticeComponent,
    ScheduleListComponent,
    ScheduleDetailsComponent,
    CreateScheduleComponent,
    AssignmentListComponent,
    UploadAssignmentComponent,
    NotesListComponent,
    NavbarComponent,
    FooterComponent,
  ],
  entryComponents:[
    StudentListComponent,
    StudentDetailsComponent,
    UpdateStudentComponent,
    CreateStudentComponent,
    FacultyListComponent,
    FacultyDetailsComponent,
    UpdateFacultyComponent,
    CreateFacultyComponent,
    SubjectListComponent,
    SubjectDetailsComponent,
    NoticeListComponent,
    UploadNoticeComponent,
    ScheduleListComponent,
    ScheduleDetailsComponent,
    CreateScheduleComponent,
    AssignmentListComponent,
    UploadAssignmentComponent,
    NotesListComponent,
    NavbarComponent,
    FooterComponent,
  ]
})
export class SharedModule { }
