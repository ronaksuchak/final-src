import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardService } from '../shared/services/auth-guard.service';
import { StudentAuthGuardService } from '../shared/services/student-auth-guard.service';
import { StudentAssignmentsComponent } from './student-assignments/student-assignments.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import { StudentScheduleComponent } from './student-schedule/student-schedule.component';
import { StudentSubjectsComponent } from './student-subjects/student-subjects.component';

const routes: Routes = [
  { path: 'student/home', 
    component: StudentHomeComponent,
    canActivate:[AuthGuardService,StudentAuthGuardService],
  },
  
  { path: 'student/subjects', 
    component:  StudentSubjectsComponent,
    canActivate:[AuthGuardService,StudentAuthGuardService],
  },
  
  { path: 'student/schedule', 
    component:  StudentScheduleComponent,
    canActivate:[AuthGuardService,StudentAuthGuardService],
  },
  
  { path: 'student/assignments', 
    component: StudentAssignmentsComponent,
    canActivate:[AuthGuardService,StudentAuthGuardService],
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
