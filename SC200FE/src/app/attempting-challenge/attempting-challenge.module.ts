import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MonacoEditorModule } from 'ngx-monaco';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon'
import { MatGridListModule } from '@angular/material/grid-list';
import { MatMenuModule } from '@angular/material/menu';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import {CdkTreeModule} from '@angular/cdk/tree';
import { HttpClientModule } from '@angular/common/http';

import { FolderStructureModule } from './folder-structure/folder-structure.module';
import { AttemptingChallengeRoutingModule } from './attempting-challenge-routing.module';
import { AttemptingChallengeComponent } from './attempting-challenge.component';
import { FolderUpload } from './comp/folder_upload';
import { EditorComponent } from './editor/editor.component';
import { FilesService } from './files.service';
import { AttemptViewComponent } from './attempt-view/attempt-view.component';
import { MatListModule, MatChipsModule } from '@angular/material';
@NgModule({
  imports: [
    CommonModule,
    AttemptingChallengeRoutingModule,
    MatToolbarModule,
    FlexLayoutModule,
    MatIconModule,
    MatGridListModule,
    MatMenuModule,
    MatDialogModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    FolderStructureModule,
    MatCardModule,
    CdkTreeModule,
    HttpClientModule,
    MonacoEditorModule.forRoot(),
    MatListModule,
    MatChipsModule
  ],
  declarations: [
    AttemptingChallengeComponent,
    EditorComponent,
    FolderUpload,
    AttemptViewComponent
  ],
  providers: [FilesService]
})
export class AttemptingChallengeModule { }
