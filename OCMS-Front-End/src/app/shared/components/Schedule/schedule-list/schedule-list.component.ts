import { Component, OnInit } from '@angular/core';
import{ schedule } from '../../../models/schedule';
import { ScheduleService } from '../../../services/schedule.service'
import { ActivatedRoute,Router } from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule,MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import { ViewChild } from '@angular/core';
import { ProcessedSchedule } from 'src/app/shared/models/ProcessedSchedule';

@Component({
  selector: 'app-schedule-list',
  templateUrl: './schedule-list.component.html',
  styleUrls: ['./schedule-list.component.css']
})
export class ScheduleListComponent implements OnInit {

  schedules:ProcessedSchedule[]=[];
  // schedule_id!: number;
  //   subject_id!: number;
  //   calender_date!: Date;
  //   start_time!: string;
  //   end_time!: string;
  //   faculty_id!: number;
  //   link!: number;

  displayedColumns: string[] = ['calender_date','subject_name', 'faculty_name', 'start_time','end_time','link'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  searchKey!:string;


  constructor(private scheduleService:ScheduleService,private router:Router) { }

  ngOnInit(): void {
    this.getSchedules();
  }

  getSchedules(){
    this.scheduleService.getAll().subscribe(data=>{
     // console.log(data);
      this.schedules=data;
      console.log(this.schedules);
      this.dataSource=new MatTableDataSource(this.schedules);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort=this.sort;
    });
  }

  scheduleDetails(id: number){
    this.router.navigate(['/schedule-details', id]);
  }
  onsearchClear(){
    this.searchKey="";
    this.applyFilter();
  }

  applyFilter(){
    this.dataSource.filter=this.searchKey.trim().toLowerCase();
  }
}
