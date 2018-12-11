import { ScoringService } from './../scoring.service';
import { CompilationService } from './../compilation.service';
import { Component, OnInit, Input } from '@angular/core';
import { Profile } from '../profile';

@Component({
  selector: 'app-scoring',
  templateUrl: './scoring.component.html',
  styleUrls: ['./scoring.component.css']
})
export class ScoringComponent implements OnInit {

  @Input()
  detail: any;
  receivedData;
  myField = '';
  value: number;
  profile: Profile;
  percent;
  showFlag = false;
  constructor(private scoringService: ScoringService, private compilationService: CompilationService) { }

  ngOnInit() {
    this.compilationService.receiveHtml('hgjhj')
      .subscribe(data => {
        this.receivedData = data;
        this.render();
        this.sendToProfile();
        this.showFlag = true;
      });
    console.log(this.detail);
  }

  retry() {

  }

  home() {

  }

  render() {
    let i = 1;
    while (this.receivedData[i] !== '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">') { i++; }
    let j = 1;
    while (i < this.receivedData.length) {
      if (this.receivedData[i] === '</html>') {
        this.myField += this.receivedData[i];
        break;
      }
      this.myField += this.receivedData[i];
      if (j === 83) {
        console.log(this.receivedData[i]);
        this.percent = this.receivedData[i].match(/(\d+)(.\d)*/g);
        this.percent = parseFloat(this.percent[0]);
        console.log(this.percent);
        this.value = this.percent * this.detail.maxScore / 100;
        console.log(this.value);

      }
      i++;
      j++;
    }
  }

  sendToProfile() {
    this.profile = new Profile(this.detail.challengeId, this.detail.challengeTitle, this.detail.userId, this.detail.value);
      this.scoringService.sendToProfile(this.profile)
        .subscribe(data => {
          console.log(data);
        });
  }

}
