import { Router } from '@angular/router';
import { ShareService } from './../../share.service';
import { ScoringService } from './../scoring.service';
import { CompilationService } from './../compilation.service';
import { Component, OnInit, Input } from '@angular/core';
import { Score } from '../score';

@Component({
  selector: 'app-scoring',
  templateUrl: './scoring.component.html',
  styleUrls: ['./scoring.component.css']
})
export class ScoringComponent implements OnInit {

  detail: any;
  receivedData;
  myField = '';
  value: number;
  profile: Score;
  percent;
  showFlag = false;
  count: number = 0;

  constructor(private scoringService: ScoringService, 
    // private compilationService: CompilationService, 
    private shareService: ShareService,
    private router: Router){ }

  ngOnInit() {
    this.shareService.getValue()
    .subscribe(data => {
      this.detail = data;
      console.log(this.detail);
      this.count = this.count + 1;
      if(this.detail.solved === 1){
        this.value = this.detail.challengeScore;
        this.percent = 100;
      }
      else{
        this.value = 0;
        this.percent = 0;
      }
      if(this.count === 1){
        this.sendToProfile();
      }
      this.showFlag = true;
    });
    // this.compilationService.receiveHtml('hgjhj')
    //   .subscribe(data => {
    //     this.receivedData = data;
    //     this.render();
    //     this.sendToProfile();
    //     this.showFlag = true;
    //   });
    // console.log(this.detail);
  }

  ngOnDestroy(): void {
    //Called once, before the instance is destroyed.
    //Add 'implements OnDestroy' to the class.
    
  }

  retry() {
    this.router.navigate(['../attempt/' + this.detail.challengeId]);
  }

  home() {
    this.router.navigate(['../']);
  }

  // render() {
  //   let i = 1;
  //   while (this.receivedData[i] !== '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">') { i++; }
  //   let j = 1;
  //   while (i < this.receivedData.length) {
  //     if (this.receivedData[i] === '</html>') {
  //       this.myField += this.receivedData[i];
  //       break;
  //     }
  //     this.myField += this.receivedData[i];
  //     if (j === 83) {
  //       console.log(this.receivedData[i]);
  //       this.percent = this.receivedData[i].match(/(\d+)(.\d)*/g);
  //       this.percent = parseFloat(this.percent[0]);
  //       console.log(this.percent);
  //       this.value = this.percent * this.detail.maxScore / 100;
  //       console.log(this.value);

  //     }
  //     i++;
  //     j++;
  //   }
  // }

  sendToProfile() {
    let status;
    if(this.detail.challengeScore === this.value){
      status = 'solved';
    }
    else{
      status = 'Unsolved'
    }
    this.profile = new Score(this.detail.challengeId, this.detail.challengeTitle, this.detail.userId, this.value, this.detail.challengeScore, status);
    console.log(this.profile);
      this.scoringService.sendToProfile(this.profile)
        .subscribe(data => {
          console.log(data);
        });
  }

}
