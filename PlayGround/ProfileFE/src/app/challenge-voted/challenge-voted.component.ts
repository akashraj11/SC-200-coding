import { Component, OnInit, Input } from '@angular/core';
import { Profile } from '../profile';

@Component({
  selector: 'app-challenge-voted',
  templateUrl: './challenge-voted.component.html',
  styleUrls: ['./challenge-voted.component.css']
})
export class ChallengeVotedComponent implements OnInit {

  constructor() { }

  @Input()
  profile: Profile;

  ngOnInit() {
  }

}
