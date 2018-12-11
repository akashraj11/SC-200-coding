import { Component, OnInit } from '@angular/core';
import {HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-recommedation-card',
  templateUrl: './recommedation-card.component.html',
  styleUrls: ['./recommedation-card.component.css']
})
export class RecommedationCardComponent implements OnInit {
  title = 'RecommendationSystem';
  name:string= '' ;
  challenges=[];
  isClicked:boolean=false;

  constructor(private http:HttpClient) {
   }
   ngOnInit() {
  }
   search(){
    // var http:HttpClient;
    this.http.get('http://localhost:8086/api/v1/challenge/recommendation/'+this.name).subscribe((res:any)=> {
        this.challenges=res;
        // console.log(this.challenges);
    })

  }
  attempt(){
    
  }

}
