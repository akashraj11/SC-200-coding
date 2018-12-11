import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { ShowProfileComponent } from './show-profile/show-profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ChallengeAttemptedComponent } from './challenge-attempted/challenge-attempted.component';
import { ChallengeCreatedComponent } from './challenge-created/challenge-created.component';
import { ChallengeVotedComponent } from './challenge-voted/challenge-voted.component';
import { ProfileComponent } from './profile/profile.component';
import { MatTabsModule, MatCardModule, MatFormFieldControl, MatFormFieldModule, MatButtonModule, MatInputModule } from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ShowProfileComponent,
    UpdateProfileComponent,
    ChallengeAttemptedComponent,
    ChallengeCreatedComponent,
    ChallengeVotedComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatTabsModule,
    AppRoutingModule,
    HttpClientModule,
    MatCardModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
