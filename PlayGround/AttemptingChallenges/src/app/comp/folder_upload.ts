import {ChangeDetectorRef, Component} from '@angular/core';
import { FilesService } from '../files.service'
import { FileService } from '../folder-structure/directory/file.service';
import { Router } from '@angular/router';


@Component({
  selector: 'folder-upload',
  templateUrl: './folder_upload.html',
  styleUrls: ['./folder_upload.css']
})
export class FolderUpload {
  
  canDropFolder = typeof DataTransferItem.prototype.webkitGetAsEntry === 'function';
  uploadPaths = [];
  
  constructor(private cdr: ChangeDetectorRef , private filesServie : FilesService,private fileService:FileService , private router: Router) {}
  
  dragenter(event) {
    // indicates valid drop data
    // false allows drop
    return Array.prototype.every.call(
      event.dataTransfer.items,
      item => item.kind !== 'file'
    );
  }
  
  dragover(event) {
    // indicates valid drop data
    // false allows drop
    return Array.prototype.every.call(
      event.dataTransfer.items,
      item => item.kind !== 'file'
    );
  }
  
  
  uploadedFiles;

  filesPicked(files) {
    this.uploadedFiles=files;
    this.uploadPaths = [];
    Array.prototype.forEach.call(files, file => {
      this.uploadPaths.push(file.webkitRelativePath);
    });
    this.handleFileSelect();
  }
  
  private parseFileEntry(fileEntry) {
    return new Promise((resolve, reject) => {
      fileEntry.file(
        file => {
          resolve(file);
        },
        err => {
          reject(err);
        }
      );
    });
  }
  

      // Read in the image file as a data URL.
      // reader.readAsDataURL(f);

  private handleFileSelect() {
    
    var files = this.uploadedFiles; // FileList object
    const textFiles = [];
    const fileContent = [];
    // Loop through the FileList and render image files as thumbnails.
    for (var i = 0, f; f = files[i]; i++) {

      // Only process text files.
      if (!f.type.match('text.*')) {
        continue;
      }
 
      textFiles.push(f.name);

      var reader = new FileReader();
      reader.onload = function( e) {
      fileContent.push(e.target['result']);
    };
      reader.readAsText(f);
        };
      this.filesServie.StoreFiles(this.uploadPaths, textFiles , fileContent);
       this.filesServie.DisplayFiles();
      this.fileService.addUploadedFiles();
      // Read in the image file as a data URL.
      // reader.readAsDataURL(f);
    }
  

  
  private upload(tree, path) {
    tree.files.forEach(file => {
      this.uploadPaths.push(path + file.name);
    });
    tree.directories.forEach(directory => {
      const newPath = path + directory.name + '/';
      this.uploadPaths.push(newPath);
      this.upload(directory, newPath);
    });
  }

//need to send a http request
  public onCLick(){
    this.fileService.addUploadedFiles();
  }
}
