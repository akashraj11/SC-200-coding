import { DescriptionComponent } from './description/description.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule,
        MatSelectModule,
        MatButtonModule,
        MatInputModule} from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { UpdateChallengeComponent } from './update-challenge/update-challenge.component';
import { AddChallengeComponent } from './add-challenge/add-challenge.component';

@NgModule({
  declarations: [
    AppComponent,
    DescriptionComponent,
    UpdateChallengeComponent,
    AddChallengeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
    MatInputModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
