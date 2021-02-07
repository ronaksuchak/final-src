import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardService } from '../shared/services/auth-guard.service';
import { CcAuthGuardService } from '../shared/services/cc-auth-guard.service';
import { CcfacultyComponent } from './cc-faculty/ccfaculty.component';
import { CchomeComponent } from './cc-home/cchome.component';
import { CcnoticeComponent } from './cc-notice/ccnotice.component';
import { CcscheduleComponent } from './cc-schedule/ccschedule.component';
import { CcstudentComponent } from './cc-student/ccstudent.component';
import { CcsubjectComponent } from './cc-subject/ccsubject.component';

const routes: Routes = [

  { path: 'cc/faculties', 
    component: CcfacultyComponent,
    canActivate:[AuthGuardService,CcAuthGuardService],
  },

  { path: 'cc/home', component:  CchomeComponent,
    canActivate:[AuthGuardService,CcAuthGuardService],
  },

  { path: 'cc/notices', component:  CcnoticeComponent,
    canActivate:[AuthGuardService,CcAuthGuardService],
  },

  { path: 'cc/schedule', component:  CcscheduleComponent,
    canActivate:[AuthGuardService,CcAuthGuardService],
  },

  { path: 'cc/students', component:  CcstudentComponent,
    canActivate:[AuthGuardService,CcAuthGuardService],
  },

  { path: 'cc/subjects', component:  CcsubjectComponent,
    canActivate:[AuthGuardService,CcAuthGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
   exports: [RouterModule]
})
export class CourseCoordinatorRoutingModule { }
