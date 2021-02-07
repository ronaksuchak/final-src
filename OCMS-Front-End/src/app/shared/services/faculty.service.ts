import { faculty } from './../models/faculty';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from './data.service';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class FacultyService extends DataService {
  url1:string="http://localhost:8082/faculty";
  constructor(httpClient: HttpClient) {

    super('http://localhost:8082/faculty', httpClient);
  }

  update(resource: any) {
    console.log(resource); // here student_id faculty_id cannot be used as a generic type so it will always give err
    return this.httpclient
      .post(this.url1 + '/' + resource.faculty_id, resource)
      .pipe(catchError(this.errorHandler));
  }

  faculty!: faculty;
  getFaculty() {
    return this.faculty;
  }

  setFaculty(f:any ) {
    this.faculty=f;
  }

}
