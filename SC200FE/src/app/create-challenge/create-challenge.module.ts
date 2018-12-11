import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule, MatSelectModule, MatButtonModule, MatInputModule, MatTabsModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';

import { DescriptionComponent } from './description/description.component';
import { UpdateChallengeComponent } from './update-challenge/update-challenge.component';
import { AddChallengeComponent } from './add-challenge/add-challenge.component';

import { ChallengeService } from './challenge.service';

import { CreateChallengeRoutingModule } from './create-challenge-routing.module';

@NgModule({
  imports: [
    CommonModule,
    CreateChallengeRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
    MatInputModule,
    HttpClientModule,
    MatTabsModule
  ],
  declarations: [
    DescriptionComponent,
    UpdateChallengeComponent,
    AddChallengeComponent
  ],
  providers: [
    ChallengeService
  ]
})
export class CreateChallengeModule { }
