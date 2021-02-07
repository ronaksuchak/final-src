import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CreateScheduleComponent } from 'src/app/shared/components/Schedule/create-schedule/create-schedule.component';
@Component({
  selector: 'app-cchome',
  templateUrl: './cchome.component.html',
  styleUrls: ['./cchome.component.css']
})
export class CchomeComponent implements OnInit {

  constructor(private router:Router,private dialog : MatDialog) { }

  ngOnInit(): void {
  }

  onCreate(){
    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = true;
    dialogconfig.autoFocus = true;
    dialogconfig.width = "60%"; 
    this.dialog.open(CreateScheduleComponent,dialogconfig);
   }
}
