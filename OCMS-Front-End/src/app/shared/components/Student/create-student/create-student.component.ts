import { Component, OnInit } from '@angular/core';
import { student } from '../../../models/student';
import { StudentService } from '../../../services/student.service';
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css'],
})
export class CreateStudentComponent implements OnInit {
  student: student = new student();

  constructor(
    private studentService: StudentService,
    private router: Router,
    public dialogRef: MatDialogRef<CreateStudentComponent>
  ) { }

  ngOnInit(): void { }

  saveStudent() {
    this.studentService.create(this.student).subscribe(
      (data) => {
        console.log(data);
        this.goToStudentList();
      },
      (error) => console.log(error)
    );
  }

  goToStudentList() {
   
    window.location.reload();
    // this.router.navigate(['/cc/students']);
  }

  onSubmit() {
    this.dialogRef.close();
    console.log(this.student);
    this.saveStudent();
  }

  cancel() {
    this.dialogRef.close();
  }
}
