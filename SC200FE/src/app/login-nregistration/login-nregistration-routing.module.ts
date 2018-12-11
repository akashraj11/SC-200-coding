import { RegisterComponent } from './register/register.component';
import { Component } from '@angular/core';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { AuthGuard } from './_guards';
import { HeaderComponent } from './header/header.component';
import { LoginNRegistrationComponent } from './login-nregistration.component';

const routes: Routes = [
  {path: 'register',  component: RegisterComponent},
  {path: '', component: LoginNRegistrationComponent,
  children: [
    { path: '', component: HomeComponent, canActivate: [AuthGuard]},
    { path: 'logout', component: HeaderComponent },
    // { path: 'login', component: LoginComponent },
    // { path: 'register', component: RegisterComponent },
    { path: 'profile/:id', loadChildren: '../profile/profile.module#ProfileModule',canActivate: [AuthGuard]},
    { path: 'challenge', loadChildren: '../create-challenge/create-challenge.module#CreateChallengeModule',canActivate: [AuthGuard]},
    { path: 'attempt/:id', loadChildren: '../attempting-challenge/attempting-challenge.module#AttemptingChallengeModule',runGuardsAndResolvers:"paramsOrQueryParamsChange",canActivate: [AuthGuard]},
    { path: 'results', loadChildren: '../scoring/scoring.module#ScoringModule',canActivate: [AuthGuard]},
    { path: '**', redirectTo: 'logout' }
  ]}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginNRegistrationRoutingModule { }
