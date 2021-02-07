import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { CreateScheduleComponent } from 'src/app/shared/components/Schedule/create-schedule/create-schedule.component';

@Component({
  selector: 'app-ccschedule',
  templateUrl: './ccschedule.component.html',
  styleUrls: ['./ccschedule.component.css']
})
export class CcscheduleComponent implements OnInit {

  constructor(private dialog : MatDialog) { }

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
