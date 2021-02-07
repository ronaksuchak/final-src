import { Component, OnInit } from '@angular/core';
import{ subject } from '../../../models/subject';
import { SubjectService } from '../../../services/subject.service'
import { ActivatedRoute,Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-subject-details',
  templateUrl: './subject-details.component.html',
  styleUrls: ['./subject-details.component.css'],
})
export class SubjectDetailsComponent implements OnInit {
  id: number = 1;
  subject: subject = new subject();
  constructor(
    private subjectService: SubjectService,
    private router: Router,
    private route: ActivatedRoute,
    public dialogRef: MatDialogRef<SubjectDetailsComponent>
  ) {}

  ngOnInit(): void {
    //this.id = this.route.snapshot.params['id'];
    this.subject = this.subjectService.getSubject();
    this.subject = new subject();
    this.subjectService.getById(this.id).subscribe((data) => {
      this.subject = data;
    });
  }

  cancel() {
    //public dialogRef: MatDialogRef<SubjectDetailsComponent>
    this.dialogRef.close();
  }
}
