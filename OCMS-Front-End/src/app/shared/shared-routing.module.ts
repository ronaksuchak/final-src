import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AssignmentListComponent } from './components/Assignment/assignment-list/assignment-list.component';
import { CreateFacultyComponent } from './components/Faculty/create-faculty/create-faculty.component';
import { CreateScheduleComponent } from './components/Schedule/create-schedule/create-schedule.component';
import { CreateStudentComponent } from './components/Student/create-student/create-student.component';
import { FacultyDetailsComponent } from './components/Faculty/faculty-details/faculty-details.component';
import { FacultyListComponent } from './components/Faculty/faculty-list/faculty-list.component';
import { NotesListComponent } from './components/Notes/notes-list/notes-list.component';
import { NoticeListComponent } from './components/Notice/notice-list/notice-list.component';
import { ScheduleDetailsComponent } from './components/Schedule/schedule-details/schedule-details.component';
import { ScheduleListComponent } from './components/Schedule/schedule-list/schedule-list.component';
import { StudentDetailsComponent } from './components/Student/student-details/student-details.component';
import { StudentListComponent } from './components/Student/student-list/student-list.component';
import { SubjectDetailsComponent } from './components/Subject/subject-details/subject-details.component';
import { SubjectListComponent } from './components/Subject/subject-list/subject-list.component';
import { UpdateFacultyComponent } from './components/Faculty/update-faculty/update-faculty.component';
import { UpdateStudentComponent } from './components/Student/update-student/update-student.component';
import { UploadAssignmentComponent } from './components/Assignment/upload-assignment/upload-assignment.component';
import { UploadNoticeComponent } from './components/Notice/upload-notice/upload-notice.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AuthGuardService } from './services/auth-guard.service';

const routes: Routes = [

{ path:'notice-list', 
  component: NoticeListComponent,
  canActivate:[AuthGuardService]
},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SharedRoutingModule { }
