import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginRegisterModule } from './login-register/login-register.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    LoginRegisterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
