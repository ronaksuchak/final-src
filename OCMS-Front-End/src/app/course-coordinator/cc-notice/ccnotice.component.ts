import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ccnotice',
  templateUrl: './ccnotice.component.html',
  styleUrls: ['./ccnotice.component.css']
})
export class CcnoticeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  viewAllNotices(){
    this.router.navigate(['/notice-list']);
  }
}
