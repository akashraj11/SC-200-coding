import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ScoringComponent } from './scoring/scoring.component';

const scoringRoutes: Routes = [
  {path: '', component: ScoringComponent},
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(scoringRoutes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class ScoringRoutingModule { }
