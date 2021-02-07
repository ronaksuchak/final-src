import { Component, OnInit } from '@angular/core';
import { faculty } from '../../../models/faculty';
import { FacultyService } from '../../../services/faculty.service';
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-faculty',
  templateUrl: './create-faculty.component.html',
  styleUrls: ['./create-faculty.component.css'],
})
export class CreateFacultyComponent implements OnInit {
  faculty: faculty = new faculty();

  constructor(
    private facultyService: FacultyService,
    private router: Router,
    public dialogRef: MatDialogRef<CreateFacultyComponent>
  ) {}

  ngOnInit(): void {}

  saveFaculty() {
    this.facultyService.create(this.faculty).subscribe(
      (data) => {
        console.log(data);
        this.goToFacultyList();
      },
      (error) => console.log(error)
    );
  }

  goToFacultyList() {
    //this.router.navigate(['/faculty-list']);
    
    window.location.reload();
  }

  onSubmit() {
    this.dialogRef.close();
    console.log(this.faculty);
    this.saveFaculty();
  }

  cancel() {
    this.dialogRef.close();
  }
}
