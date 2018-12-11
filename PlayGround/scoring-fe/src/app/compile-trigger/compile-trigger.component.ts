import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompilationService } from '../compilation.service';

@Component({
  selector: 'app-compile-trigger',
  templateUrl: './compile-trigger.component.html',
  styleUrls: ['./compile-trigger.component.css']
})
export class CompileTriggerComponent implements OnInit {

  model: any = {};
  flag = 0;
  receivedData;
  myField = '';
  constructor() { }

  ngOnInit() {
    this.model.solved = 1;
  }

  onSubmit() {
    console.log('SUCCESS!! :-)\n\n' + JSON.stringify(this.model));
    this.flag = 1;
  }

}
