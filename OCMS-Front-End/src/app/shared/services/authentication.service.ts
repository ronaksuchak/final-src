import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Observable } from 'rxjs';
import { NotFoundError } from '../errors/not-found-error';
import { BadInput } from '../errors/bad-input';
import { AppError } from '../errors/app-error';
import { user } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  user:user=new user;
  isLoggedIn:boolean=false;
  // role:any;
  authUrl = "http://localhost:8081/login";

  constructor(private http: HttpClient) { }

  login(f1:string,f2:string) {
      return this.http.get<user>(this.authUrl+"/"+f1+"/"+f2).pipe(catchError(this.errorHandler));
    }

    getCurrentUser(){
      let user1=localStorage.getItem("userDetails");
      if(user1!=null){
       this.user=JSON.parse(user1);  
      }
      this.isLoggedIn=true;
      return this.user;
    }

    setUser(u:user){
      this.user=u;
      if(this.user!=null){
        this.isLoggedIn=true;
      }
      console.log(this.user);
    }

    getUser(){
      console.log(this.user);
      return this.user;
    }

    private errorHandler(error: Response) {
      if (error.status === 400) return throwError(new BadInput(error.json()));
  
      if (error.status === 404) return throwError(new NotFoundError());
      return throwError(new AppError(error));
    }
  }

