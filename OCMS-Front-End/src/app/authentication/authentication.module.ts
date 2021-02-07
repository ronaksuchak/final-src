import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthenticationRoutingModule } from './authentication-routing.module';
import { LoginComponent } from './login/login.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [LoginComponent, ResetPasswordComponent, HomeComponent],
  imports: [
    CommonModule,
    FormsModule,
    AuthenticationRoutingModule,
    SharedModule
  ],
  exports:[
    LoginComponent,
    ResetPasswordComponent,
    HomeComponent
  ]
})
export class AuthenticationModule { }
