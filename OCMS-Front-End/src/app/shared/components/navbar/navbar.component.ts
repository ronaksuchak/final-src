import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';
import { MatToolbarModule } from '@angular/material/toolbar/toolbar-module';
import * as $ from 'jquery';
import { user } from 'src/app/shared/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthenticationService, private router: Router) { }
  
  user: user = new user;
  username!:string;
  role:any;
  isAdmin:boolean=false;
  isFaculty:boolean=false;
  isStudent:boolean=false;
  invalidLogin:boolean=false;
  ngOnInit(): void {

    let user1=localStorage.getItem("userDetails");
    if(user1!=null){
    this.user=JSON.parse(user1);
      
    }
    this.username=this.user.userName;

    if(this.user.role=="cc"){
      this.isAdmin=true;
    }else if(this.user.role=="faculty"){
      console.log("xyz");
      this.isFaculty=true;
    }else if(this.user.role=="student"){
      this.isStudent=true;
    }else{
      this.invalidLogin=true;
    }
    
    


    $(document).ready(function () {
    
      $('#sidebarCollapse').on('click', function () {
          $('#sidebar').toggleClass('active');
      });


      $("a").attr("aria-expanded","true");


     });
    }

    logout(){
      localStorage.removeItem("userDetails");
      localStorage.clear();
      console.log("in log out");
      this.router.navigate(['login']).then(()=>{
        window.location.reload();
      });
    }
}
