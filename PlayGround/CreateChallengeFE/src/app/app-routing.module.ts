import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AddChallengeComponent } from './add-challenge/add-challenge.component';
import { UpdateChallengeComponent } from './update-challenge/update-challenge.component';

const appRoutes: Routes = [
  {path: 'addChallenge', component: AddChallengeComponent},
  {path: 'updateChallenge/:id', component: UpdateChallengeComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(
      appRoutes
    )
  ],
  declarations: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
