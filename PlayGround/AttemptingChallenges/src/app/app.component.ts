import { Component } from '@angular/core';
import { FileElement } from './folder-structure/directory/model/file-element';
import { FileService } from './folder-structure/directory/file.service';
import { Observable } from 'rxjs';
import { FilesService } from './files.service'
import { delay } from 'q';
import { AngularWaitBarrier } from 'blocking-proxy/built/lib/angular_wait_barrier';
import { STYLESHEET_MAP_PROVIDER } from '@angular/flex-layout';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AttemptingChallenges';

  public fileElements: Observable<FileElement[]>;
  
  files: File[];
  
  currentRoot: FileElement;
  currentPath: string;
  canNavigateUp = false;

  constructor(public fileService: FileService, public filesService: FilesService) { }

  ngOnInit() {

    this.fileService.getStructureOnInit().subscribe(data=>{
      console.log("hey the service is invoked", data);
      this.fileElements = this.filesService.allFiles;
      this.updateFileElementQuery();
    
    });
    }
    private fileElement_array : FileElement[];
    

  addFile(file: { name: string, parent:string,url:string,id:string }) {
    this.fileService.addFiles({id:file.id, isFolder: false, name: file.name, parent:file.parent,url:file.url,content:null });
    this.updateFileElementQuery();
  }





  addFolder(folder: { name: string,parent:string,url:string,id:string }) {
    this.fileService.add({id:folder.id, isFolder: true, name: folder.name, parent: folder.parent,url:folder.url,content:null });
    this.updateFileElementQuery();
  }
  onShow(){

    
    this.fileElement_array = this.fileService.fileElements_array;
    console.log(this.fileElement_array);
    //need to change the parent from string to id of its parent.
    for(let i=0;i<this.fileElement_array.length;i++){
      if(this.fileElement_array[i].isFolder){
        this.addFolder(this.fileElement_array[i]);
        this.updateFileElementQuery();
      }
      else{
        
        this.addFile(this.fileElement_array[i]);
        this.updateFileElementQuery();
      }
    }
  
  }

 


  removeElement(element: FileElement) {
    this.fileService.delete(element.id);
    this.updateFileElementQuery();
  }

  navigateToFolder(element: FileElement) {
    this.currentRoot = element;
    this.updateFileElementQuery();
    this.currentPath = this.pushToPath(this.currentPath, element.name);
    this.canNavigateUp = true;
  }

  navigateUp() {
    if (this.currentRoot && this.currentRoot.parent === 'root') {
      this.currentRoot = null;
      this.canNavigateUp = false;
      this.updateFileElementQuery();
    } else {
      this.currentRoot = this.fileService.get(this.currentRoot.parent);
      this.updateFileElementQuery();
    }
    this.currentPath = this.popFromPath(this.currentPath);
  }

  moveElement(event: { element: FileElement; moveTo: FileElement }) {
    this.fileService.update(event.element.id, { parent: event.moveTo.id });
    this.updateFileElementQuery();
  }

  renameElement(element: FileElement) {
    this.fileService.update(element.id, { name: element.name });
    this.updateFileElementQuery();
  }

  updateFileElementQuery() {
    this.fileElements=this.fileService.queryInFolder(this.currentRoot ? this.currentRoot.id : 'root');
  }

  pushToPath(path: string, folderName: string) {
    let p = path ? path : '';
    p += `${folderName}/`;
    return p;
  }

  popFromPath(path: string) {
    let p = path ? path : '';
    let split = p.split('/');
    split.splice(split.length - 2, 1);
    p = split.join('/');
    return p;
  }
}
