import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FolderUpload } from './comp/folder_upload';

@NgModule({
  declarations: [
    AppComponent,
    FolderUpload
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class FolderUploadModule { }
