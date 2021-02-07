import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import{ student } from '../../../models/student';
import { StudentService } from '../../../services/student.service'

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css'],
})
export class UpdateStudentComponent implements OnInit {
  student: student = new student();
  constructor(
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute,
    public dialogRef: MatDialogRef<UpdateStudentComponent>
  ) {}

  ngOnInit(): void {
    this.student = this.studentService.getStudent();
    console.log(student);
    this.studentService.getById(this.student.student_id).subscribe(
      (data) => {
        this.student = data;
        console.log(this.student);
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    this.studentService.update(this.student).subscribe(
      (data) => {
        this.goToStudentList();
      },
      (error) => console.log(error)
    );
  }

  goToStudentList() {
    // this.router.navigate(['/student-list']);
    this.dialogRef.close();
    window.location.reload();
  }

  cancel() {
    this.dialogRef.close();
  }
}
