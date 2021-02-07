import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardService } from '../shared/services/auth-guard.service';
import { FacultyAuthGuardService } from '../shared/services/faculty-auth-guard.service';
import { FacultyAssignmentsComponent } from './faculty-assignments/faculty-assignments.component';
import { FacultyHomeComponent } from './faculty-home/faculty-home.component';
import { FacultySubjectsComponent } from './faculty-subjects/faculty-subjects.component';

const routes: Routes = [
  { path: 'faculty/home', 
    component: FacultyHomeComponent,
    canActivate:[AuthGuardService,FacultyAuthGuardService],
  },

  { path: 'faculty/subjects', 
    component: FacultySubjectsComponent,
    canActivate:[AuthGuardService,FacultyAuthGuardService],
  },
  
  { path: 'faculty/assignments',
    component: FacultyAssignmentsComponent,
    canActivate:[AuthGuardService,FacultyAuthGuardService],
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacultyRoutingModule { }
