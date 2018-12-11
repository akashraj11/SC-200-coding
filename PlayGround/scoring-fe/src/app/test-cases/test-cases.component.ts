import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-test-cases',
  templateUrl: './test-cases.component.html',
  styleUrls: ['./test-cases.component.css']
})
export class TestCasesComponent implements OnInit {

  @Input()
  tests;

  constructor() { }

  ngOnInit() {
  }

}
