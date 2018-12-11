import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import { MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule } from '@angular/material';
import { LayoutModule } from '@angular/cdk/layout';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AlertComponent } from './_directives';
import { AuthGuard } from './_guards';
import { AlertService, AuthenticationService, UserService } from './_services';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { HeaderComponent } from './header/header.component';

import { RecommedationCardComponent } from './home/recommedation-card/recommedation-card.component';

import { LoginNRegistrationRoutingModule } from './login-nregistration-routing.module';
import { LoginNRegistrationComponent } from './login-nregistration.component';
import { QuestionListComponent } from './home/question-list/question-list.component';
import {NgxPaginationModule} from 'ngx-pagination' ;
import {SearchService} from './home/search.service';
import {SearchComponent} from './home/search/search.component';
import { from } from 'rxjs';
@NgModule({
  imports: [
    CommonModule,
    LoginNRegistrationRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    MatCardModule,
    HttpClientModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    NgxPaginationModule,
    NgbModule.forRoot()


  ],
  declarations: [
    AlertComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    LoginNRegistrationComponent,
    RecommedationCardComponent,
    QuestionListComponent,
	SearchComponent
  ],
  providers: [
    
    AuthGuard,
    AlertService,
    AuthenticationService,
    UserService,
  SearchService
  

    // provider used to create fake backend
  ],
  bootstrap: [HomeComponent]
})
export class LoginNRegistrationModule { }
