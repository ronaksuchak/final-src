import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-faculty-home',
  templateUrl: './faculty-home.component.html',
  styleUrls: ['./faculty-home.component.css']
})
export class FacultyHomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  addNewNotice(){
    this.router.navigate(['/cc/upload-notice']);
  }
}
