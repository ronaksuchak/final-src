import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../shared/services/authentication.service';
import { user } from 'src/app/shared/models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

user: user = new user;
invalidLogin: boolean =false;
constructor(private router: Router, private http: HttpClient,private authService: AuthenticationService) { }

 ngOnInit(): void {
  //  this.getValues();
  }



   onSubmit(f: NgForm) {
     this.authService.login(f.value.username,f.value.password).subscribe((data) => {
       this.user = data;
      this.authService.setUser(this.user);

      if(this.user==null){
        this.invalidLogin=true;
      }else{
        localStorage.setItem('userDetails',JSON.stringify(this.user));

        if(this.user.role=="cc"){
          this.router.navigate(['/cc/home']).then(()=>{
            window.location.reload();
          });
      
        }else if(this.user.role=="faculty"){
           this.router.navigate(['/faculty/home']).then(()=>{
             window.location.reload();
           });
        }else{
          this.router.navigate(['/student/home']).then(()=>{
            window.location.reload();
          });
        }
      }
     });
    
  }
}

