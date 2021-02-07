import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class FacultyAuthGuardService implements CanActivate{
  
  constructor(private router: Router, private authService: AuthenticationService) { }
  
  canActivate(){
  
    if(this.authService.getUser().role=="faculty") {
      return true;
    }
    this.router.navigate(['login']).then(()=>{
      window.location.reload();
    });
    return false;
  }
}
