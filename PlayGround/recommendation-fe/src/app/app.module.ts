import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import {MaterialModule} from '@angular/material'

import{ MatCardModule } from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RecommedationCardComponent } from './recommedation-card/recommedation-card.component';
import { MainNavComponent } from './main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    RecommedationCardComponent,
    MainNavComponent,
    //HttpClientModule
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    MatCardModule,
    HttpClientModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
