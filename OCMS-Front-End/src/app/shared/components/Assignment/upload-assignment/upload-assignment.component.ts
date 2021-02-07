import { CreateFacultyComponent } from './../../Faculty/create-faculty/create-faculty.component';
import { Component, OnInit } from '@angular/core';
import{ assignment } from '../../../models/assignment';
import { AssignmentService } from '../../../services/assignment.service'
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-upload-assignment',
  templateUrl: './upload-assignment.component.html',
  styleUrls: ['./upload-assignment.component.css']
})
export class UploadAssignmentComponent implements OnInit {

  assignment:assignment=new assignment();

  constructor(private assignmentService:AssignmentService,private router:Router,public dialogRef: MatDialogRef<CreateFacultyComponent>) { }


  ngOnInit(): void {
  }

  saveAssignment(){
    this.assignmentService.create(this.assignment).subscribe( data =>{
      console.log(data);
      this.goToAssignmentList();
    },
    error => console.log(error));
  }

  goToAssignmentList(){
    // this.router.navigate(['/faculty/assignments']);
 
    window.location.reload();
  }
  
  onSubmit(){
    this.dialogRef.close();
    console.log(this.assignment);
    this.saveAssignment();
  }
  
  cancel() {
    this.dialogRef.close();
  }

}
