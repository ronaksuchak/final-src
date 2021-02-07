import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private router: Router, private authService: AuthenticationService) { }

  canActivate(){
    console.log(this.authService.getCurrentUser());
    if(this.authService.isLoggedIn){
      return true;
    }
    this.router.navigate(['login']).then(()=>{
      window.location.reload();
    });
    return false;
  }
}
