import { Profile } from '../profile';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-challenge-attempted',
  templateUrl: './challenge-attempted.component.html',
  styleUrls: ['./challenge-attempted.component.css']
})
export class ChallengeAttemptedComponent implements OnInit {

  constructor() { }
  @Input()
  profile: Profile;

  ngOnInit() {
  }

}
