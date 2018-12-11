import { UpdateChallengeComponent } from './update-challenge/update-challenge.component';
import { AddChallengeComponent } from './add-challenge/add-challenge.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'add', component: AddChallengeComponent},
  {path: 'update/:id', component: UpdateChallengeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreateChallengeRoutingModule { }
