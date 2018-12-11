import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { ProfileComponent } from './profile/profile.component';

const profileRoutes: Routes = [
  {path: '', component: ProfileComponent},
  { path: '../../challenge', loadChildren: '../create-challenge/create-challenge.module#CreateChallengeModule'},

];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(
      profileRoutes
    )
  ],
  declarations: [],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
