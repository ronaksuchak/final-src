import { student } from './../models/student';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from './data.service';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { BadInput } from '../errors/bad-input';
import { NotFoundError } from '../errors/not-found-error';
import { AppError } from '../errors/app-error';

@Injectable({
  providedIn: 'root',
})
export class StudentService extends DataService {
  form: any;
  url1:string="http://localhost:8081/coordinator/students";
  student!: student;
  constructor(private httpClient: HttpClient) {
    super('http://localhost:8081/coordinator/students', httpClient);
  }


  update(resource: any) {
    console.log(resource); // here student_id faculty_id cannot be used as a generic type so it will always give err
    return this.httpclient
      .post(this.url1 + '/' + resource.student_id, resource)
      .pipe(catchError(this.errorHandler));
  }



  getStudent() {
    return this.student;
  }

  setStudent(s: any) {
    this.student = s;
  }
}
