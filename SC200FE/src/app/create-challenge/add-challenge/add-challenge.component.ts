import { QuestDetail } from './../quest-detail';
import { Component, OnInit } from '@angular/core';
import * as uuid from 'uuid';

@Component({
  selector: 'app-add-challenge',
  templateUrl: './add-challenge.component.html',
  styleUrls: ['./add-challenge.component.css']
})
export class AddChallengeComponent implements OnInit {

  constructor() { }

  quest: QuestDetail = new QuestDetail();
  flag = 1;
  id;
  userName;
  ngOnInit() {
    this.userName = JSON.parse(localStorage.getItem('currentUser')).username;
    console.log(this.userName);
    const myId = uuid.v4();
    this.id = myId;
  }

}
