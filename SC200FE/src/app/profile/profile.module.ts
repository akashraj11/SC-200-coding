import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTabsModule, MatCardModule, MatFormFieldControl, MatFormFieldModule, MatButtonModule, MatInputModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { ShowProfileComponent } from './show-profile/show-profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ChallengeAttemptedComponent } from './challenge-attempted/challenge-attempted.component';
import { ChallengeCreatedComponent } from './challenge-created/challenge-created.component';
import { ChallengeVotedComponent } from './challenge-voted/challenge-voted.component';
import { ProfileComponent } from './profile/profile.component';

import { ProfileService} from './profile.service';
import { ProfileRoutingModule } from './profile-routing.module';

@NgModule({
  imports: [
    CommonModule,
    MatTabsModule,
    HttpClientModule,
    MatCardModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    ProfileRoutingModule
  ],
  declarations: [
    ShowProfileComponent,
    UpdateProfileComponent,
    ChallengeAttemptedComponent,
    ChallengeCreatedComponent,
    ChallengeVotedComponent,
    ProfileComponent
  ],
  providers: [ProfileService]
})
export class ProfileModule { }
