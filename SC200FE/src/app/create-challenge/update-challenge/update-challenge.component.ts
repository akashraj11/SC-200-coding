import { QuestDetail } from './../quest-detail';
import { ChallengeService } from './../challenge.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-update-challenge',
  templateUrl: './update-challenge.component.html',
  styleUrls: ['./update-challenge.component.css']
})
export class UpdateChallengeComponent implements OnInit {

  constructor(private challengeService: ChallengeService, private route: ActivatedRoute) { }

  quest: QuestDetail;
  questId: string;
  flag = 2;

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      const id = params.get('id');
      this.questId = id;
    } );
    this.challengeService.getChallengeById(this.questId)
      .subscribe(data => {
        this.quest = data;
        console.log(this.quest);
    });
  }

}
