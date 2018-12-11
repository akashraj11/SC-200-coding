import { Injectable } from '@angular/core';
import { FileElement } from '../directory/model/file-element';
import { Observable } from 'rxjs';
import { v4 } from 'uuid';
import { BehaviorSubject } from 'rxjs';
import { FilesService } from 'src/app/files.service';



export interface IFileService {
  add(fileElement: FileElement);
  delete(id: string);
  update(id: string, update: Partial<FileElement>);
  queryInFolder(folderId: string): Observable<FileElement[]>;
  get(id: string): FileElement;
}
@Injectable()
export class FileService implements IFileService {

  private map = new Map<string, FileElement>();

  constructor(private filesService:FilesService) { }

  add(fileElement: FileElement) {
    this.map.set(fileElement.id, this.clone(fileElement));
    return fileElement;
    console.log(fileElement);
  }
  addFiles(fileElem: FileElement) {
    this.map.set(fileElem.id, this.clone(fileElem));
    return fileElem;
  }

  fileElements_array:FileElement[]=[];

  addUploadedFiles(){
    var fileelem:FileElement;
    var temp = this.filesService.GetAllFiles();
    console.log("from uploaded files function");
    console.log(temp);
    
    
    var len = temp.length;
    for(let i = 0 ; i<len;i++){
      if(temp[i]!=null){
      var splitted=temp[i].split('/');

      var len_temp = splitted.length;
      var split_string:Array<string>=[];

      for(let j=0;j<len_temp;j++){
        splitted[j]=splitted[j].toString()
      }
      
//storing the splitted strings into an array and checkign whether it is a file or folder
      for(let j=0;j<len_temp;j++){
        
         split_string.push(splitted[j]);
      }
     

      for(let j=0;j<split_string.length;j++){
        
        
        if(split_string[j].indexOf('.')>0){

        var fileelem:FileElement=
          {name:split_string[j],
          id:v4(),
          content:null,
          isFolder:false,
          url:temp[i],
          parent:split_string[j-1]
        }
          this.fileElements_array.push(fileelem);
        }
        else{
          //if it is first file then its parent is root else the previous folder
          if(j==0){
            var fileelem:FileElement =
            {name:split_string[j],
            id:v4(),
            content:null,
            parent:'root',
            isFolder:true,
            url:null
          }
          
          }
          else{
          var fileelem:FileElement =
            {name:split_string[j],
            id:v4(),
            content:null,
            parent:split_string[j-1],
            isFolder:true,
            url:null
          }
        }
          this.fileElements_array.push(fileelem);
        }
      }
    
    }
  
  }
  console.log(this.filesService.DisplayFiles());
   //need to remove duplicates in the fileElements_array;
   this.fileElements_array=this.remove_duplicates(this.fileElements_array);
   for(let i=0;i<this.fileElements_array.length;i++){
    if(this.fileElements_array[i].parent=='root'){
      ;
    }
    else{
      let temp = this.fileElements_array[i].parent;
      var temp_id;
      for(let j=0;j<this.fileElements_array.length;j++){
        if(temp==this.fileElements_array[j].name){
          temp_id=this.fileElements_array[j].id;
        }
      }
      this.fileElements_array[i].parent=temp_id;
      this.fileElements_array[i].content=this.filesService.GetContent(this.fileElements_array[i].name);
    }
  }
  console.log("after id update");
  console.log(this.fileElements_array);
  return this.fileElements_array;
   
  
}
 
  delete(id: string) {
    this.map.delete(id);
  }

  update(id: string, update: Partial<FileElement>) {
    let element = this.map.get(id);
    element = Object.assign(element, update);
    this.map.set(element.id, element);
  }

  private querySubject: BehaviorSubject<FileElement[]>;
  queryInFolder(folderId: string) {
    //console.log(this.map);
    const result: FileElement[] = [];
    this.map.forEach(element => {
      if (element.parent === folderId) {
        result.push(this.clone(element));
      }
    });
    if (!this.querySubject) {
      this.querySubject = new BehaviorSubject(result);
    } else {
      this.querySubject.next(result);
    }
    return this.querySubject.asObservable();
  }

  get(id: string) {
    return this.map.get(id);
  }

  clone(element: FileElement) {
    return JSON.parse(JSON.stringify(element));
  }



  getStructureOnInit(){

    this.filesService.getTemplate().subscribe(data=>{
      
      this.filesService.setPaths(data['paths']); 
      this.filesService.setContent(data['contents']);
      console.log("1232");
      this.addUploadedFiles();
      
  });
  console.log("dkv");
  console.log("1232");
  return this.querySubject.asObservable();
 
  }

  remove_duplicates(fileElements_array:FileElement[]){
    var fileElements_array2:FileElement[] = [];
    let len = fileElements_array.length;
    for(let i=0;i<len-1;i++){
      for(let j=i+1;j<len;j++){
        if(fileElements_array[i]!=null && fileElements_array[j]!=null){
            if(fileElements_array[i].name==fileElements_array[j].name && fileElements_array[i].parent==fileElements_array[j].parent){
          fileElements_array[j]=null;
        }
      }
      }
    }
    var j = 0;
     for(let i=0;i<len;i++){
       if(fileElements_array[i]!=null){
         fileElements_array2[j]=fileElements_array[i];
         j++;
       }
     }
    return  fileElements_array2;
  }
}
