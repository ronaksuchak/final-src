import { FacultyService } from './../../../services/faculty.service';
import { Component, OnInit } from '@angular/core';
import{ notice } from '../../../models/notice';
import { NoticeService } from '../../../services/notice.service'
import { Router } from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule,MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import { ViewChild } from '@angular/core';
import { processedNotice } from 'src/app/shared/models/ProcessedNotice';


@Component({
  selector: 'app-notice-list',
  templateUrl: './notice-list.component.html',
  styleUrls: ['./notice-list.component.css'],
})
export class NoticeListComponent implements OnInit {
  notices: processedNotice[] = [];
  /**
 notice_id!:number;
        coordinator_id!:number;
        fauclty_id!:number;
        notice_title!:string;
        description!:string;
 */
  displayedColumns: string[] = [
    'notice_id',
    'fauclty_name',
    'notice_title',
    'description',
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  searchKey!: string;

  constructor(private noticeService: NoticeService, private router: Router,private facultyService: FacultyService,) {}

  ngOnInit(): void {
    this.getNotices();
  }

  getNotices() {
    this.noticeService.getAll().subscribe((data) => {
      console.log(data);
      this.notices = data;
      this.dataSource = new MatTableDataSource(this.notices);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      
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
