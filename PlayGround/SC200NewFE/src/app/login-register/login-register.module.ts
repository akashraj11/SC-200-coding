import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [LoginComponent, HeaderComponent],
  exports: [LoginComponent,HeaderComponent]
})
export class LoginRegisterModule { }
