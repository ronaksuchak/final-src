import { student } from './../../../models/student';
import { CreateStudentComponent } from './../create-student/create-student.component';
import { MatDialogModule } from '@angular/material/dialog';
import { Component, OnInit,ViewChild } from '@angular/core';
import { StudentService } from '../../../services/student.service';
import { Router } from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule,MatSort} from '@angular/material/sort';
import {MatIconModule} from '@angular/material/icon';
import {CommonModule} from '@angular/common';
import{ReactiveFormsModule,FormsModule,FormControl,FormGroup} from '@angular/forms';
import {MatPaginator} from '@angular/material/paginator';
import {MatFormFieldControl,MatFormField,MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogConfig , MatDialog} from '@angular/material/dialog';
import { UpdateStudentComponent } from '../update-student/update-student.component';


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
})
export class StudentListComponent implements OnInit {
  students: student[] = [];

  /*
{"student_id":1,"first_name":"mukund","last_name":"kale","email_id":"mukund@gmail.com",
"prn":97,"phone_no":123123,"coordinator_id":1,"dob":"2020-01-01"}
*/
  displayedColumns: string[] = [
    'student_id',
    'first_name',
    'last_name',
    'email_id',
    'prn',
    'phone_no',
    'dob',
    'action',
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  searchKey!: string;

  constructor(
    private studentService: StudentService,
    private router: Router,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getStudents();
  }

  getStudents() {
    this.studentService.getAll().subscribe((data) => {
      this.students = data;
      this.dataSource = new MatTableDataSource(this.students);
      console.log(this.dataSource);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  studentDetails(id: any) {
    console.log(id);
    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = true;
    dialogconfig.autoFocus = true;
    dialogconfig.width = '60%';
    this.studentService.setStudent(id);
    this.dialog.open(UpdateStudentComponent, dialogconfig);
  }

  updateStudent(id: number) {
    console.log(id);
    this.router.navigate(['/update-student', id]);
  }

  deleteStudent(id: number) {
    this.studentService.delete(id).subscribe((data) => {
      console.log(data);
      this.getStudents();
      
    });
  }

  onsearchClear() {
    this.searchKey = '';
    this.applyFilter();
  }

  applyFilter() {
    this.dataSource.filter = this.searchKey.trim().toLowerCase();
  }
}
