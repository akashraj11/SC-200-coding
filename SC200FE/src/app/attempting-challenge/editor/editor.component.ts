import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { FileService } from "./../folder-structure/directory/file.service";
import { Component, OnInit, Input, OnChanges } from "@angular/core";
import { MonacoFile } from "ngx-monaco";
import { FilesService } from "../files.service";
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import * as $ from 'jquery';
import { ScoringModel } from 'src/app/scoring-model';
import { ShareService } from 'src/app/share.service';

@Component({
  selector: "app-editor",
  templateUrl: "./editor.component.html",
  styleUrls: ["./editor.component.css"]
})
export class EditorComponent implements OnInit, OnChanges {
  @Input() fileName: string;
  @Input() userName: string;
  @Input() challengeId: string;
  @Input() completechallenge;
  @Input() uid: string;   //  not for docker
  count: number = 0;
  content = "";
  httpResponse;
  stompClient = null;
  sessionId: String;
  socketUrl = "http://35.154.116.88:8183/compile";

  title = "app";
  options = {
    theme: "vs-dark",
    language: "java"
  };

  file: MonacoFile = {
    uri: "",
    language: "java",
    content: ""
  };

  dataToScoring: ScoringModel;
  flag: number = 0;

  constructor(
    private filesService: FilesService,
    private fileService: FileService,
    private shareService: ShareService, 
    private router: Router
  ) {
    this.initializeWebSocketConnection();
  }

  ngOnInit() {
    console.log("ngOninit evoked --------------->");
    //this.file.content = "public class Hello";
    // this.changeContent();
    //this.file.content = this.content;
  }
  ngOnChanges() {
    console.log("ngOnChanges evoked---------------> ");
    this.changeContentOfEditor();
  }

  initializeWebSocketConnection() {
    const ws = new SockJS(this.socketUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    //connect to service using stompclinet
    this.stompClient.connect(
      {},
      function(frame) {
        console.log("Socket Connection Established");
        that.sessionId = /\/([^\/]+)\/websocket/.exec(ws._transport.url)[1];
        that.stompClient.subscribe("/results/" + that.sessionId, message => {
          if (message.body) {
           that.httpResponse = JSON.parse(message.body).body;
           //that.httpResponse = message.body;
            console.log(that.httpResponse);
            if(that.httpResponse == "BUILD SUCCESS") {
              that.flag = 1;
            }
            else {
              that.flag = 0;
            }
          }
        });
        that.stompClient.subscribe(
          "/chat/errors/" + that.sessionId,
          message => {
            if (message.body) {
              console.log(message.body);
            }
          }
        );
      }
    );
  }

  changeContentOfEditor() {
    console.log("file uri is ", this.file.uri);
    this.file = {
      ...this.file,
      content: this.filesService.GetContent(this.fileName),
      uri: this.fileName
    };
    // this.file.content = data["content"];
    // this.file.uri = this.fileName;
  }
  onFileChange(file: MonacoFile) {
    this.content = file.content;
    this.file.content=file.content;
    console.log(this.content);
    console.log(file.content);
  }

  public saveCode() {
    console.log(this.content);
    //this.file.content = this.content;
    // this.file = {
    //     ...this.file,
    //     content: this.content
    // }
    console.log(this.file.uri, this.file.content);
    // var a =this.file.uri;
    // var b = this.file.content;
    // var file : any[];
    this.filesService.setContent(this.file.uri, this.file.content);
    this.filesService.SaveFile(this.userName, this.challengeId).subscribe();
  }
  public compileCode() {
    //console.log(this.file.uri , this.file.content);
    // var a =this.file.uri;
    // var b = this.file.content;
    // var file : any[];
    this.saveCode();
    this.stompClient.send(
      "/app/send/message/" + this.sessionId,
      {},
      this.userName + "/" + this.challengeId
    );
    // this.filesService.RunFile(this.userName, this.challengeId).subscribe(data => {
    //   this.httpResponse = data;
    //   console.log(this.httpResponse);
    //   console.log(data);
    // });
  }
  public showResults() {
    console.log(this.httpResponse);
  }

  submit() {
    this.dataToScoring = new ScoringModel(
      this.completechallenge.challengeId, this.completechallenge.challengeTitle, this.uid, this.completechallenge.maxScore, this.flag);
    this.shareService.setValue(this.dataToScoring);
    console.log('inside onSubmit');
    this.router.navigate(['../../results']);
  }
}
