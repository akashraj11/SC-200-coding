import { PageNotFoundComponent } from './../page-not-found/page-not-found.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: '', loadChildren: '../login-nregistration/login-nregistration.module#LoginNRegistrationModule',runGuardsAndResolvers:"paramsOrQueryParamsChange"},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class CoreRoutingModule { }
