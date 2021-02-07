import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogModule } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CreateStudentComponent } from 'src/app/shared/components/Student/create-student/create-student.component';

@Component({
  selector: 'app-ccstudent',
  templateUrl: './ccstudent.component.html',
  styleUrls: ['./ccstudent.component.css']
})
export class CcstudentComponent implements OnInit {

  constructor(private router:Router,private dialog : MatDialog) { }

  ngOnInit(): void {
  }

  onCreate(){
    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = true;
    dialogconfig.autoFocus = true;
    dialogconfig.width = "60%"; 
    this.dialog.open(CreateStudentComponent,dialogconfig);
   }
}
