import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DirectoryComponent } from './directory/directory.component'
import { FormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { FileService } from './directory/file.service';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon'
import { MatGridListModule } from '@angular/material/grid-list';
import { MatMenuModule } from '@angular/material/menu';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatTreeModule, MatCheckboxModule, MatButtonToggleModule } from '@angular/material';
@NgModule({
  imports: [
    CommonModule,
    MatToolbarModule,
    FlexLayoutModule,
    MatIconModule,
    MatGridListModule,
    MatMenuModule,
    MatDialogModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    FormsModule,
    FlexLayoutModule,
    MatCardModule,
    MatTreeModule,
    MatCheckboxModule,
    MatButtonToggleModule
  ],
  exports: [DirectoryComponent],
  providers: [FileService],
  entryComponents: [],
  declarations: [DirectoryComponent,
   ]
  })
export class FolderStructureModule { }
