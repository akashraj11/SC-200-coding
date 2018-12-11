import { EditorComponent } from './editor/editor.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MonacoEditorModule } from 'ngx-monaco';
import { AppComponent } from './app.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon'
import { MatGridListModule } from '@angular/material/grid-list';
import { MatMenuModule } from '@angular/material/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule}  from '@angular/router'
import { FolderStructureModule } from './folder-structure/folder-structure.module';
import { FolderUpload } from './comp/folder_upload';
import { HttpClientModule } from '@angular/common/http';
import {CdkTreeModule} from '@angular/cdk/tree';
@NgModule({
  declarations: [
    AppComponent,
    EditorComponent,
    FolderUpload
  ],
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
    FolderStructureModule,
    FlexLayoutModule,
    MatCardModule,
    CdkTreeModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: ':file/:name' , component : EditorComponent},
      {path: '' , component : EditorComponent },
    ]),
    MonacoEditorModule.forRoot()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
