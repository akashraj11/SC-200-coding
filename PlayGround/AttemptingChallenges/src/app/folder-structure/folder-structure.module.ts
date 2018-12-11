import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DirectoryComponent } from './directory/directory.component'
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { FileService } from './directory/file.service';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon'
import { MatGridListModule } from '@angular/material/grid-list';
import { MatMenuModule } from '@angular/material/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { RenameDialogComponent } from './directory/modals/rename-dialog/rename-dialog.component';
import { NewFolderDialogComponent } from './directory/modals/new-folder-dialog/new-folder-dialog.component';
import { NewFileDialogComponent } from './directory/modals/new-file-dialog/new-file-dialog.component';
 
@NgModule({
  imports: [
    CommonModule,
    MatToolbarModule,
    FlexLayoutModule,
    MatIconModule,
    MatGridListModule,
    MatMenuModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    BrowserModule,
    FormsModule,
    FlexLayoutModule,
    MatCardModule    
  ],
  exports: [DirectoryComponent],
  providers: [FileService],
  entryComponents: [RenameDialogComponent,
    NewFolderDialogComponent,
    NewFileDialogComponent],
  declarations: [DirectoryComponent,
    RenameDialogComponent,
    NewFolderDialogComponent,
    NewFileDialogComponent]
  })
export class FolderStructureModule { }
