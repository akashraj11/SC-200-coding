import {ChangeDetectorRef, Component} from 'angular2/core';

@Component({
  selector: 'folder-upload',
  templateUrl: 'src/folder_upload.html'
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
  
  drop(event) {
    const entries = Array.from(event.dataTransfer.items)
                    .filter(item => item.kind === 'file')
                    .map(item => item.webkitGetAsEntry());
    this.buildTree(entries, '').then(tree => {
      this.uploadPaths = [];
      this.upload(tree, '');
      this.cdr.markForCheck();
    });
    // indicates valid drop data
    // false allows drop
    return false;
  }
  
  filesPicked(files) {
    console.log(files);
    this.uploadPaths = [];
    Array.prototype.forEach.call(files, file => {
      this.uploadPaths.push(file.webkitRelativePath);
    });
    console.log(this.uploadPaths);
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
  
  private parseDirectoryEntry(directoryEntry) {
    const directoryReader = directoryEntry.createReader();
    return new Promise((resolve, reject) => {
      directoryReader.readEntries(
        entries => {
          resolve(this.buildTree(entries, directoryEntry.name));
        },
        err => {
          reject(err);
        }
      );
    });
  }
  
  private buildTree(entries, name) {
    const tree = {name, files: [], directories: []};
    const promises = [];
    entries.forEach(entry => {
      if (entry.isFile) {
        const promise = this.parseFileEntry(entry).then(file => {
          tree.files.push(file);
        });
        promises.push(promise);
      } else if (entry.isDirectory) {
        const promise = this.parseDirectoryEntry(entry).then(directory => {
          tree.directories.push(directory);
        });
        promises.push(promise);
    });
    return Promise.all(promises).then(() => tree);
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
}
