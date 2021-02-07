import { SubjectDetailsComponent } from './../subject-details/subject-details.component';
import { Component, OnInit } from '@angular/core';
import{ subject } from '../../../models/subject';
import { SubjectService } from '../../../services/subject.service'
import { Router } from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule,MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import { ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
  styleUrls: ['./subject-list.component.css'],
})
export class SubjectListComponent implements OnInit {
  subjects: subject[] = [];
  displayedColumns: string[] = [
    'subject_id',
    'subject_name',
    'theory_marks',
    'practical_marks',
    'faculty_id',
    'action',
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  searchKey!: string;

  constructor(
    private subjectService: SubjectService,
    private router: Router,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getSubjects();
  }

  getSubjects() {
    this.subjectService.getAll().subscribe((data) => {
      console.log(data);
      this.subjects = data;
      this.dataSource = new MatTableDataSource(this.subjects);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  subjectDetails(id: any) {
    //this.router.navigate(['/subject-details', id]);
    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = true;
    dialogconfig.autoFocus = true;
    dialogconfig.width = '60%';
    this.subjectService.setSubject(id);
    this.dialog.open(SubjectDetailsComponent, dialogconfig);
    console.log(id);
  }

  onsearchClear() {
    this.searchKey = '';
    this.applyFilter();
  }

  applyFilter() {
    this.dataSource.filter = this.searchKey.trim().toLowerCase();
  }
}
