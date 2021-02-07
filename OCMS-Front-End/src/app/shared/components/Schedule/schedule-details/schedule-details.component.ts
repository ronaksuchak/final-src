import { Component, OnInit } from '@angular/core';
import{ schedule } from '../../../models/schedule';
import { ScheduleService } from '../../../services/schedule.service'
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-schedule-details',
  templateUrl: './schedule-details.component.html',
  styleUrls: ['./schedule-details.component.css']
})
export class ScheduleDetailsComponent implements OnInit {

  id:number=1;
  schedule:schedule=new schedule();
  constructor(private scheduleService:ScheduleService,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.schedule = new schedule();
    this.scheduleService.getById(this.id).subscribe( data => {
      this.schedule = data;
    });
  }
}
