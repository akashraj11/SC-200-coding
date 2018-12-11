import { QuestDetail } from './../quest-detail';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-challenge',
  templateUrl: './add-challenge.component.html',
  styleUrls: ['./add-challenge.component.css']
})
export class AddChallengeComponent implements OnInit {

  constructor() { }

  quest: QuestDetail = new QuestDetail();
  flag = 1;
  ngOnInit() {
  }

}
