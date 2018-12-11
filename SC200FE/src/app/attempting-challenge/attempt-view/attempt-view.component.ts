import { Component, OnInit, Input } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { Routes } from '@angular/router';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-attempt-view',
  templateUrl: './attempt-view.component.html',
  styleUrls: ['./attempt-view.component.css']
})
export class AttemptViewComponent implements OnInit {
  @Input()
  completechallenge1;
  constructor() { }

  ngOnInit() {
  }

  solve(){

  }

}
