import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { File } from './folder-structure/directory/model/file'
import { containsElement } from '@angular/animations/browser/src/render/shared';
import { MonacoFile } from 'ngx-monaco';
import { FileElement } from './folder-structure/directory/model/file-element';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};
@Injectable({
  providedIn: 'root'
})
export class FilesService {

  constructor(private http: HttpClient) { }
 
  allFiles;
  textFiles : String[] = [];
  fileContent;
  files:[string];
  url = "http://172.23.239.117:8020/";
  url1 = "http://172.23.239.117:8021/compile";
  newurl:string = "";
  httpresponse;


  StoreFiles(allFiles , textFiles , fileContent){
    this.allFiles = allFiles;
    this.textFiles = textFiles;
    this.fileContent = fileContent;
  }

  DisplayFiles(){
    console.log(this.textFiles);
    console.log(this.fileContent);
    console.log(this.allFiles);

  
      
  }

  SaveFile(file:MonacoFile){
    
  
   this.newurl= this.GetFilePath(file.uri);
   file.uri=this.newurl;
   
    console.log(file);
    return this.http.post(this.url + "file/create", file, httpOptions);

  }

  RunFile(file){
    
   
      this.newurl= this.GetFilePath(file.uri);
      console.log(this.newurl);
     return this.http.post(this.url1,this.newurl, httpOptions);

  }
getTemplate(){
  return this.http.post(this.url + "file", "src/", httpOptions);
}

setPaths(data){

  this.allFiles = data;
  this.setTextFiles();
}

setTextFiles(){

  for(var i=0; i < this.allFiles.length; i++ )
  {
    if(this.allFiles[i]!=null){
    var index = this.allFiles[i].lastIndexOf("/");
    this.textFiles[i] = this.allFiles[i].substring(index+1,this.allFiles[i].length);
    }
  }
}


setContent(data){

  this.fileContent = data;
  console.log(this.fileContent);
}

  showResponse(){
    return this.httpresponse;
  }

  GetAllFiles(){
    return this.allFiles;
  }
 

  GetContent(fileName:string){

   
    let index;
    for(let i=0; i < this.textFiles.length; i++ )
    {
      console.log(this.textFiles[i]);
      if(fileName == this.textFiles[i]){
        index=i;
         }
        }

    
    return this.fileContent[index];

  
}
GetFilePath(fileName){
   this.files = this.GetAllFiles();
  for(let i=0;i<this.files.length;i++){
    if(this.files[i].includes(fileName)){
      console.log(this.files[i]);
      return this.files[i];
    }
  }
}
}
