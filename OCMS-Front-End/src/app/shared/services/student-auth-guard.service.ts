import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class StudentAuthGuardService implements CanActivate{
  constructor(private router: Router, private authService: AuthenticationService) { }
  
  canActivate(){
  
    if(this.authService.getUser().role=="student") {
      return true;
    }
    this.router.navigate(['login']).then(()=>{
      window.location.reload();
    });
    return false;
  }
}
