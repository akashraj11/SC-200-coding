import { Component, OnInit } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {

  quesList=[];
  id:string="";

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit() {
   
      
       var http:HttpClient;
      // console.log("gggggggggggggggggggggggggggggg");
      //console.log(`hey ${id}`);
      this.http.get(environment.apiUrl+'challenge/challengeAPI/v1/basic').subscribe((res:any)=> {
          console.log("gggggggggggggggggggggggggggggg");
        this.quesList=res;
          console.log("gggggg ", res);
          
    
      })
  }

  View(id:string){
    console.log("gghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhg");
    this.router.navigate(['attempt',id]);
  }

}



