import { Component, Input, Output, EventEmitter } from '@angular/core';
import { FileElement } from './model/file-element';
import { MatMenuTrigger } from '@angular/material/menu';
import { MatDialog } from '@angular/material/dialog';
import { NewFolderDialogComponent } from './modals/new-folder-dialog/new-folder-dialog.component';
import { RenameDialogComponent } from './modals/rename-dialog/rename-dialog.component';
import { NewFileDialogComponent } from './modals/new-file-dialog/new-file-dialog.component';
import { Router } from '@angular/router';
import { FileService } from './file.service';
@Component({
  selector: 'app-directory',
  templateUrl: './directory.component.html',
  styleUrls: ['./directory.component.css']
})
export class DirectoryComponent {

  constructor(public dialog: MatDialog, private router: Router,private fileService:FileService ) { 
  }

  @Input() fileElements: FileElement[];
  @Input() canNavigateUp: string;
  @Input() path: string;

  @Output() folderAdded = new EventEmitter<{ name: string }>();
  @Output() elementRemoved = new EventEmitter<FileElement>();
  @Output() elementRenamed = new EventEmitter<FileElement>();
  @Output() elementMoved = new EventEmitter<{ element: FileElement; moveTo: FileElement }>();
  @Output() navigatedDown = new EventEmitter<FileElement>();
  @Output() navigatedUp = new EventEmitter();
  @Output() fileAdded = new EventEmitter<{ name: string }>();

  deleteElement(element: FileElement) {
    this.elementRemoved.emit(element);
  }


  navigate(element: FileElement) {

    if (element.isFolder) {
      this.navigatedDown.emit(element);
    }
    else {
       
      var names = element.name.split(".");
      this.router.navigate(["/" + names[1] + "/" + names[0]]);

    }

  }

  navigateUp() {
    this.router.navigate([""]);
    this.navigatedUp.emit();
  }

  moveElement(element: FileElement, moveTo: FileElement) {
    this.elementMoved.emit({ element: element, moveTo: moveTo });
  }

  openNewFolderDialog() {
    let dialogRef = this.dialog.open(NewFolderDialogComponent);
    dialogRef.afterClosed().subscribe(res => {
      console.log(res);
      if (res) {
        this.folderAdded.emit({ name: res });
      }
    });
  }
  openNewFileDialog() {
    let dialogRef1 = this.dialog.open(NewFileDialogComponent);
    dialogRef1.afterClosed().subscribe(res => {
      // console.log(res);
      if (res) {
        this.fileAdded.emit({ name: res });
        // console.log("files added");
      }
    });
  }



  openRenameDialog(element: FileElement) {
    let dialogRef = this.dialog.open(RenameDialogComponent);
    dialogRef.afterClosed().subscribe(res => {
      if (res) {
        element.name = res;
        this.elementRenamed.emit(element);
      }
    });
  }

  openMenu(event: MouseEvent, viewChild: MatMenuTrigger) {
    event.preventDefault();
    viewChild.openMenu();
  }

}
