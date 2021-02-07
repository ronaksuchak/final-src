
import { Component, OnInit } from '@angular/core';
import{ faculty } from '../../../models/faculty';
import { FacultyService } from '../../../services/faculty.service'
import { ActivatedRoute,Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-faculty-details',
  templateUrl: './faculty-details.component.html',
  styleUrls: ['./faculty-details.component.css'],
})
export class FacultyDetailsComponent implements OnInit {
  id: number = 1;
  faculty: faculty = new faculty();
  constructor(
    private facultyService: FacultyService,
    private router: Router,
    private route: ActivatedRoute,
    public dialogRef: MatDialogRef<FacultyDetailsComponent>
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.faculty = new faculty();
    this.facultyService.getById(this.id).subscribe((data) => {
      this.faculty = data;
    });
  }
  cancel() {
    //public dialogRef: MatDialogRef<FacultyDetailsComponent>
    this.dialogRef.close();
  }
}
