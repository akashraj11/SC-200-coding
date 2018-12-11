import { Component, OnInit, Input} from '@angular/core';
import { MonacoFile } from 'ngx-monaco';
import { ActivatedRoute } from '@angular/router';
import { FilesService } from '../files.service'
import { File } from '../folder-structure/directory/model/file';


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  @Input() displayFile : string;


  private fileName ;
  private content ;
  httpResponse;

  constructor(private activatedroute: ActivatedRoute , private filesService : FilesService) { }

  
  ngOnInit(): void {


    this.filesService.DisplayFiles();
    this.activatedroute.params.subscribe((params) => {

      this.fileName = params.name + "." + params.file;
      this.file.uri=this.fileName;
      this.file.language = params.file;
      console.log(this.fileName);
      this.file.content= this.filesService.GetContent(this.fileName);
      this.content = this.file.content;
});
}


  title = 'app';
  options = {
    theme: 'vs-dark',
    language: 'javascript',

  };
  file: MonacoFile = {
    uri: this.fileName,
    language: 'javascript',
    content: this.content
  };

  onFileChange(file: MonacoFile) {
    this.content = file.content;
  }

   public onClick(){
     console.log
     this.file.content=this.content;
    console.log(this.file.uri , this.file.content);

    this.filesService.SaveFile(this.file)
          .subscribe();
  }
  public Run(){


    this.filesService.RunFile(this.file)
          .subscribe(data =>{
            this.httpResponse = data;
          });

  }
  public showResults(){

    console.log(this.httpResponse);

  }

  


}

