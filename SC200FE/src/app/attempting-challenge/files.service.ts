import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { HttpHeaders } from "@angular/common/http";
import { File } from "./folder-structure/directory/model/file";
import { containsElement } from "@angular/animations/browser/src/render/shared";
import { MonacoFile } from "ngx-monaco";
import { FileElement } from "./folder-structure/directory/model/file-element";
import { Observable } from "rxjs";
import { environment } from "../../environments/environment";

// const httpOptions = {
//   headers: new HttpHeaders({
//     "Content-Type": "application/json",
//     Authorization: "my-auth-token"
//   })
// };

@Injectable({
  providedIn: "root"
})
export class FilesService {
  constructor(private http: HttpClient) {}

  allFiles;
  textFiles: String[] = [];
  fileContent;
  testData = "";
  sendContent = "";
  files: [string];
  url1 = "http://35.154.116.88:8183/compile";
  url = environment.apiUrl+"file/";
  //url1 = environment.apiUrl + "compile";
  newurl: string = "";
  httpresponse;

  StoreFiles(allFiles, textFiles, fileContent) {
    this.allFiles = allFiles;
    this.textFiles = textFiles;
    this.fileContent = fileContent;
  }

   DisplayFiles(){
     console.log(this.textFiles);
     console.log(this.fileContent);
     console.log(this.allFiles);

   }

  SaveFile(challengeId, userId) {
    var temp = this.GetAllFiles();
    var temp1=this.textFiles;
    console.log(temp);
    console.log(temp1);
    this.DisplayFiles();
    const saveBody = new Save(userId, challengeId, temp1, this.fileContent,temp);

     return this.http.post(this.url + "file/create", saveBody,{responseType:"text"});
  }

  RunFile(userId, challengeId) {
    return this.http.post(this.url1, userId + '/' + challengeId);

    // return this.http.post(this.url1, this.newurl, httpOptions);
  }
  getTemplate(challengeId: string) {
    console.log("into the get template func");
    return this.http.post(this.url + "file/struct", challengeId);
  }
  getRepsoitory(url: string, userName: string, challengeId: string) {
    return this.http.post(this.url1 + "/clone", url + '$' + userName + '$' + challengeId);
  }

  setPaths(data) {
    this.allFiles = data;
    this.setTextFiles();
  }

  setTextFiles() {
    for (var i = 0; i < this.allFiles.length; i++) {
      if (this.allFiles[i] != null) {
        var index = this.allFiles[i].lastIndexOf("/");
        this.textFiles[i] = this.allFiles[i].substring(
          index + 1,
          this.allFiles[i].length
        );
      }
    }
  }

  getContentfromUrl(filename: string): Observable<any> {
    let path = this.GetFilePath(filename);
    console.log(path);
    var content: string[];
    return this.http.post(this.url + "file/content", path);
  }

  setContent(fileName, data) {
    let index;
    for (let i = 0; i < this.textFiles.length; i++) {
      //console.log(this.textFiles[i]);
      if (fileName === this.textFiles[i]) {
        index = i;
        this.fileContent[index] = data;
      }
    }
  }

  showResponse() {
    return this.httpresponse;
  }

  GetAllFiles() {
    return this.allFiles;
  }

  GetContent(fileName: string) {
    let index;
    for (let i = 0; i < this.textFiles.length; i++) {
      //console.log(this.textFiles[i]);
      if (fileName == this.textFiles[i]) {
        index = i;
      }
    }
    return this.fileContent[index];
  }
  GetFilePath(fileName) {
    this.files = this.GetAllFiles();
    for (let i = 0; i < this.files.length; i++) {
      if (this.files[i].includes(fileName)) {
        //console.log(this.files[i]);
        return this.files[i];
      }
    }
  }
}

export class Save {
  userId: string;
  challengeId: string;
  textFile: string[];
  fileContent: string[];
  filepaths:string[];

  constructor(uid, cid, txt, file,filepath) {
    this.userId = uid;
    this.challengeId = cid;
    this.textFile = txt;
    this.fileContent = file;
    this.filepaths=filepath;
  }
}
