import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Observable } from 'rxjs';
import { NotFoundError } from '../errors/not-found-error';
import { BadInput } from '../errors/bad-input';
import { AppError } from '../errors/app-error';
import { inject } from '@angular/core/testing';

export class DataService {
  constructor(private url: string, public httpclient: HttpClient) {}

  getAll() {
    return this.httpclient
      .get<any[]>(this.url)
      .pipe(catchError(this.errorHandler));
  }

  getById(id: any) {
    return this.httpclient
      .get<any>(this.url + '/' + id)
      .pipe(catchError(this.errorHandler));
  }

  create(resource: any) {
    return this.httpclient
      .post(this.url, resource)
      .pipe(catchError(this.errorHandler));
  }


  delete(id: any) {
    return this.httpclient
      .delete(this.url + '/' + id)
      .pipe(catchError(this.errorHandler));
  }

  public errorHandler(error: Response) {
    if (error.status === 400) return throwError(new BadInput(error.json()));

    if (error.status === 404) return throwError(new NotFoundError());
    return throwError(new AppError(error));
  }
}
