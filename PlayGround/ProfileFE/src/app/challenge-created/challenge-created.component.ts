import { Profile } from './../profile';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-challenge-created',
  templateUrl: './challenge-created.component.html',
  styleUrls: ['./challenge-created.component.css']
})
export class ChallengeCreatedComponent implements OnInit {

  constructor() { }
  @Input()
  profile: Profile;

  ngOnInit() {
  }

}
