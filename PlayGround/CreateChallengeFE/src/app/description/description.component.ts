import { QuestDetail } from './../quest-detail';
import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ChallengeService } from '../challenge.service';

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css']
})
export class DescriptionComponent implements OnInit {

  constructor(private fb: FormBuilder, private questService: ChallengeService) {}

  availbLang = [ 'Java', 'Python', 'C', 'Cpp', 'Javascript' ];
  readOnlyFlag = false;

  questDesc: FormGroup;

  @Input()
  quest2send: QuestDetail;

  @Input()
  flag: number;

  ngOnInit() {
    console.log(this.quest2send);
    console.log(this.flag);
    if (this.flag === 2) {
      this.readOnlyFlag = true;
    }
    this.questDesc = this.fb.group({
      id : [this.quest2send.id, [Validators.required]],
      challengeTitle : [this.quest2send.challengeTitle, [Validators.required]],
      challengeDescription : [this.quest2send.challengeDescription, [Validators.required]],
      challengeStatement : [this.quest2send.challengeStatement, [Validators.required]],
      inputFormat : [this.quest2send.inputFormat, [Validators.required]],
      constraints : [this.quest2send.constraints, [Validators.required]],
      outputFormat : [this.quest2send.outputFormat, [Validators.required]],
      maxScore : [this.quest2send.maxScore, [Validators.required, Validators.min(5), Validators.max(100)]],
      maxRuntime : [this.quest2send.maxRuntime, Validators.required],
      programmingLang : [this.quest2send.programmingLang, Validators.required],
      topic : [this.quest2send.topic, Validators.required],
      solutionUrl : [this.quest2send.solutionUrl, [Validators.required,
        Validators.pattern('(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?')]],
      boilerPlateUrl : [this.quest2send.boilerPlateUrl, [Validators.required,
        Validators.pattern('(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?')]],
      level : [this.quest2send.level, [Validators.required, Validators.min(1), Validators.max(10)]],
      rating : [this.quest2send.rating, [Validators.required, Validators.min(1), Validators.max(10)]]
    });
  }

  get id() {return this.questDesc.get('id'); }

  get title() { return this.questDesc.get('challengeTitle'); }

  get desc() { return this.questDesc.get('challengeDescription'); }

  get stat() { return this.questDesc.get('challengeStatement'); }

  get inFormat() { return this.questDesc.get('inputFormat'); }

  get constraints() { return this.questDesc.get('constraints'); }

  get outFormat() { return this.questDesc.get('outputFormat'); }

  get maxScore() { return this.questDesc.get( 'maxScore' ); }

  get maxRuntime() { return this.questDesc.get('maxRuntime'); }

  get programmingLang() { return this.questDesc.get('programmingLang'); }

  get topic() { return this.questDesc.get('topic'); }

  get solutionUrl() { return this.questDesc.get('solutionUrl'); }

  get boilerPlateUrl() { return this.questDesc.get('boilerPlateUrl'); }

  get level() { return this.questDesc.get('level'); }

  get rating() { return this.questDesc.get('rating'); }

  onSubmit() {
    if (this.flag === 1) {
      if (this.questDesc.invalid) {
        console.log('POST Failed');
        return;
      }
      console.log(this.questDesc.value);
      alert('The form was submitted');
      this.questService.createChallenge(this.questDesc.value)
        .subscribe(data => {
          console.log('POST Successful');
        });
    } else {
      if (this.questDesc.invalid) {
        console.log('PUT Failed');
        return;
      }
      console.log(this.questDesc.value);
      alert('The form was updated');
      this.questService.updateChallenge(this.quest2send.id, this.questDesc.value)
        .subscribe(data => {
          console.log(data);
          console.log('PUT Successful');
        });
    }
    this.questDesc.reset();
  }

}
