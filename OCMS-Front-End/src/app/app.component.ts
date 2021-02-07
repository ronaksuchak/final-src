import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {CommonModule} from '@angular/common';
import{ReactiveFormsModule,FormsModule,FormControl,FormGroup} from '@angular/forms';
import {MatFormFieldControl,MatFormField,MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'OCMS-Front-End';

  constructor(private router: Router){}

  ngOnInit(){
  }
}
