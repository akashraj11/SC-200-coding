import { VotingService } from './../voting.service';
import { MatSnackBar } from '@angular/material';
import { Component, OnInit, Input } from '@angular/core';
import { Voting } from '../voting';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  @Input()
  detail: any;
  alreadyClicked = 0;
  voting: Voting;

  constructor(private snackBar: MatSnackBar, private votingService: VotingService) { }

  ngOnInit() {
    this.voting = new Voting(this.detail.challengeId, this.detail.challengeTitle, this.detail.userId);
  }

  upvote() {
    if (this.alreadyClicked === 0) {
      this.alreadyClicked = 1;
      console.log(this.voting);
      this.votingService.upVote(this.voting)
        .subscribe(data => {
          console.log(data);
        });
    } else {
      this.snackBar.open('You\'ve already Voted', 'OK', {
        duration: 2000,
      });
    }
  }

  downvote() {
    if (this.alreadyClicked === 0) {
      this.alreadyClicked = 1;
      this.votingService.downVote(this.voting)
        .subscribe(data => {
          console.log(data);
        });
    } else {
      this.snackBar.open('You\'ve already Voted', 'OK', {
        duration: 2000,
      });
    }
  }

}
