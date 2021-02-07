import { UploadAssignmentComponent } from './../../shared/components/Assignment/upload-assignment/upload-assignment.component';
import { CreateFacultyComponent } from './../../shared/components/Faculty/create-faculty/create-faculty.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { createAssignment } from 'typescript';

@Component({
  selector: 'app-faculty-assignments',
  templateUrl: './faculty-assignments.component.html',
  styleUrls: ['./faculty-assignments.component.css']
})
export class FacultyAssignmentsComponent implements OnInit {

  constructor(private router:Router,private dialog : MatDialog) { }

  ngOnInit(): void {
  }

  uploadAssignment(){
    this.router.navigate(['upload-assignment']);
  }
  onCreate(){

    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = true;
    dialogconfig.autoFocus = true;
    dialogconfig.width = "60%"; 
    this.dialog.open(UploadAssignmentComponent,dialogconfig);        
  }
}

