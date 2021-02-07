import { subject } from './../models/subject';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from './data.service';
@Injectable({
  providedIn: 'root',
})
export class SubjectService extends DataService {
  constructor(httpClient: HttpClient) {
    super('http://localhost:8081/coordinator/subjects', httpClient);
  }

  subject!: subject;
  getSubject() {
    return this.subject;
  }

  setSubject(subject: any) {
    this.subject = subject;
  }
}
