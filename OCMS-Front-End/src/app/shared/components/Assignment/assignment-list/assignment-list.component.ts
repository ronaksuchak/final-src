import { Component, OnInit } from '@angular/core';
import{ assignment } from '../../../models/assignment';
import { AssignmentService } from '../../../services/assignment.service'
import { Router } from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule,MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import { ViewChild } from '@angular/core';
@Component({
  selector: 'app-assignment-list',
  templateUrl: './assignment-list.component.html',
  styleUrls: ['./assignment-list.component.css']
})
export class AssignmentListComponent implements OnInit {

  assignments:assignment[]=[];
  displayedColumns: string[] = ['userId','id', 'title', 'body','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  searchKey!:string;


  constructor(private assignmentService:AssignmentService,private router:Router) { }

  ngOnInit(): void {
    this.getAssignments();
  }

  getAssignments(){
    this.assignmentService.getAll().subscribe(data=>{
      console.log(data);
      this.assignments=data;
      this.dataSource=new MatTableDataSource(this.assignments);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort=this.sort;

    });
  }
  onsearchClear(){
    this.searchKey="";
    this.applyFilter();
  }

  applyFilter(){
    this.dataSource.filter=this.searchKey.trim().toLowerCase();
  }

  download(id:any){
    
  }

}
