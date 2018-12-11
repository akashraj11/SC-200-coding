import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditorComponent } from './editor/editor.component';
import { AttemptingChallengeComponent } from './attempting-challenge.component';

const routes: Routes = [
  {path: '', component: AttemptingChallengeComponent,
  // children: [
  //   // {path: '' , component : AttemptingChallengeComponent },
  //   {path: ':file/:name' , component : EditorComponent,pathMatch:"full"}
    // {path: 'results', loadChildren: '../scoring/scoring.module/#ScoringModule' }
  // ],
  runGuardsAndResolvers: 'always',
}
];

@NgModule({
  imports: [RouterModule.forChild(routes),
],
  exports: [RouterModule]
})
export class AttemptingChallengeRoutingModule { }
