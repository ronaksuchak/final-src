import { UpdateFacultyComponent } from './../update-faculty/update-faculty.component';
import { Component, OnInit } from '@angular/core';
import { faculty } from '../../../models/faculty';
import { FacultyService } from '../../../services/faculty.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule, MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

@Component({
  selector: 'app-faculty-list',
  templateUrl: './faculty-list.component.html',
  styleUrls: ['./faculty-list.component.css'],
})
export class FacultyListComponent implements OnInit {
  faculties: faculty[] = [];

  displayedColumns: string[] = [
    'faculty_id',
    'first_name',
    'last_name',
    'email_id',
    'phone_no',
    'subject_id',
    'action',
  ];

  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  searchKey!: string;

  constructor(
    private facultyService: FacultyService,
    private router: Router,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getFaculties();
  }

  getFaculties() {
    this.facultyService.getAll().subscribe((data) => {
      console.log(data);
      this.faculties = data;
      this.dataSource = new MatTableDataSource(this.faculties);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  facultyDetails(id: any) {
    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = true;
    dialogconfig.autoFocus = true;
    dialogconfig.width = '60%';
    this.facultyService.setFaculty(id);
    this.dialog.open(UpdateFacultyComponent, dialogconfig);
    console.log(id);
    }

  deleteFaculty(id: number) {
    this.facultyService.delete(id).subscribe((data) => {
      console.log(data);
      this.getFaculties();
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
