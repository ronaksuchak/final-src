import { Component, OnInit } from '@angular/core';
import{ student } from '../../../models/student';
import { StudentService } from '../../../services/student.service'
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css'],
})
export class StudentDetailsComponent implements OnInit {
  id: number = 1;
  student: student = new student();
  constructor(
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute,
    public dialogRef: MatDialogRef<StudentDetailsComponent>
  ) {}

  ngOnInit(): void {
    this.student = this.studentService.getStudent();
    this.studentService.getById(this.student.student_id).subscribe((data) => {
      this.student = data;
    });
  }
  cancel() {
      this.dialogRef.close();
  }
}
