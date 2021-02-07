import { Component, OnInit } from '@angular/core';
import{ schedule } from '../../../models/schedule';
import { ScheduleService } from '../../../services/schedule.service'
import { ActivatedRoute,Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-schedule',
  templateUrl: './create-schedule.component.html',
  styleUrls: ['./create-schedule.component.css']
})
export class CreateScheduleComponent implements OnInit {

 
  schedule:schedule=new schedule();

  constructor(private scheduleService:ScheduleService,private router:Router,public dialogRef: MatDialogRef<CreateScheduleComponent>) { }


  ngOnInit(): void {
  }

  saveSchedule(){
    this.scheduleService.create(this.schedule).subscribe( data =>{
      console.log(data);
      this.goToScheduleList();
    },
    error => console.log(error));
  }

  goToScheduleList(){
    
     window.location.reload();
    // this.router.navigate(['/schedule-list']);
  }
  
  onSubmit(){
    this.dialogRef.close();
    console.log(this.schedule);
    this.saveSchedule();
  }
  cancel() {
    this.dialogRef.close();
  }
}
