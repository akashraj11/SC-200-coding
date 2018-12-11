import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ScoringRoutingModule } from './scoring-routing.module';
import { MatProgressBarModule, MatCardModule, MatIconModule, MatButtonModule, MatSnackBarModule, MatProgressSpinnerModule} from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';



import { ScoringComponent } from './scoring/scoring.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SafePipe } from './safe.pipe';
import { CompilationService } from './compilation.service';
import { VotingService } from './voting.service';
import { ScoringService } from './scoring.service';

@NgModule({
  imports: [
    CommonModule,
    ScoringRoutingModule,
    RouterModule,
    MatProgressBarModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    MatProgressSpinnerModule
  ],
  declarations: [
    ScoringComponent,
    FeedbackComponent,
    SafePipe
  ],
  providers: [
    CompilationService,
    VotingService,
    ScoringService
  ]
})
export class ScoringModule { }
