import {ChangeDetectorRef, Component} from '@angular/core';

@Component({
  selector: 'folder-upload',
  templateUrl: './folder_upload.html',
  styleUrls: ['./folder_upload.css']
})
export class FolderUpload {
  
  canDropFolder = typeof DataTransferItem.prototype.webkitGetAsEntry === 'function';
  uploadPaths = [];
  
  constructor(private cdr: ChangeDetectorRef) {}
  
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
  
  // drop(event) {
  //   const entries = Array.from(event.dataTransfer.items)
  //                   .filter(item => item.kind === 'file')
  //                   .map(item => item.webkitGetAsEntry());
  //   this.buildTree(entries, '').then(tree => {
  //     this.uploadPaths = [];
  //     this.upload(tree, '');
  //     this.cdr.markForCheck();
  //   });
  //   // indicates valid drop data
  //   // false allows drop
  //   return false;
  // }
  
  uploadedFiles;

  filesPicked(files) {
    console.log(files);
    this.uploadedFiles=files;
    this.uploadPaths = [];
    Array.prototype.forEach.call(files, file => {
      this.uploadPaths.push(file.webkitRelativePath);
    });
    console.log(this.uploadPaths);
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

  

  private handleFileSelect() {
    var files = this.uploadedFiles; // FileList object

    // Loop through the FileList and render image files as thumbnails.
    for (var i = 0, f; f = files[i]; i++) {

      console.log(f);
      // Only process image files.
      if (!f.type.match('text.*')) {
        continue;
      }
 
      var reader = new FileReader();
      reader.onload = function( e) {
        
       // console.log("hjdehjf");
        console.log(e.target['result']);
        // e.target.result should contain the text
    };
      reader.readAsText(f);
      // console.log("hello" + FileReader.readAsText(f));
      // f.charAt(0);
      // var a;
    //   var reader = new FileReader();
    //   reader.onload = function(e){
    //         reader.readAsText(f);
        
    // };
    // console.log(f);
      // // Closure to capture the file information.
      // reader.onload = (function(theFile) {
      //   return function(e) {
      //     // Render thumbnail.
 
      //     console.log("hello" + theFile.charAt(0));
      // reader.readAsText(f, $scope)
      //     // .then(function(result) {
      //     //     //$scope.textSrc = result;
          //     $scope.textSrc =angular.fromJson(result);
          //     console.log(typeof(result));
          //     console.log(typeof($scope.textSrc));
          // });         console.log(theFile.charAt(0));
        };
      // })(f);

      // Read in the image file as a data URL.
      // reader.readAsDataURL(f);
    }
  

  // document.getElementById('files').addEventListener('change', handleFileSelect, false);
  
  // private parseDirectoryEntry(directoryEntry) {
  //   const directoryReader = directoryEntry.createReader();
  //   return new Promise((resolve, reject) => {
  //     directoryReader.readEntries(
  //       entries => {
  //         resolve(this.buildTree(entries, directoryEntry.name));
  //       },
  //       err => {
  //         reject(err);
  //       }
  //     );
  //   });
  // }
  
  // private buildTree(entries, name) {
  //   const tree = {name, files: [], directories: []};
  //   const promises = [];
  //   entries.forEach(entry => {
  //     if (entry.isFile) {
  //       const promise = this.parseFileEntry(entry).then(file => {
  //         tree.files.push(file);
  //       });
  //       promises.push(promise);
  //     } else if (entry.isDirectory) {
  //       const promise = this.parseDirectoryEntry(entry).then(directory => {
  //         tree.directories.push(directory);
  //       });
  //       promises.push(promise);
  //   });
  //   return Promise.all(promises).then(() => tree);
  // }
  
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
}
