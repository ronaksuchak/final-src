import { Component, OnInit } from '@angular/core';
import { faculty } from '../../../models/faculty';
import { FacultyService } from '../../../services/faculty.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-update-faculty',
  templateUrl: './update-faculty.component.html',
  styleUrls: ['./update-faculty.component.css'],
})
export class UpdateFacultyComponent implements OnInit {
  faculty: faculty = new faculty();
  constructor(
    private facultyService: FacultyService,
    private router: Router,
    private route: ActivatedRoute,
    public dialogRef: MatDialogRef<UpdateFacultyComponent>
  ) {}

  ngOnInit(): void {

    this.faculty = this.facultyService.getFaculty();
    this.facultyService.getById(this.faculty.faculty_id).subscribe(
      (data) => {
        this.faculty = data;
        console.log(data);
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    console.log(this.faculty);
    this.facultyService.update(this.faculty).subscribe(
      (data) => {
        this.goToFacultyList();
      },
      (error) => console.log(error)
    );
  }

  goToFacultyList() {
    this.dialogRef.close();
    window.location.reload();
  }

  cancel() {
    
    this.dialogRef.close();
  }
}
