import { Injectable } from '@angular/core';
import { fakeAsync } from '@angular/core/testing';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class CcAuthGuardService  implements CanActivate{

  constructor(private router: Router, private authService: AuthenticationService) { }
  canActivate(){
  console.log(this.authService.getUser().role);
    if(this.authService.getUser().role=="cc") {
      return true;
    }
    this.router.navigate(['login']).then(()=>{
      window.location.reload();
    });
    return false;
  }
}
