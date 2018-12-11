import { Component } from '@angular/core';
import { MonacoFile } from 'ngx-monaco';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  options = {
    theme: 'vs-dark',
    language: 'java'
  };
  file: MonacoFile = {
		uri: 'index.java',
		language: 'java',
		content: `//Welcome`
	};

	onFileChange(file: MonacoFile) {
    // Handle file change
    console.log(file.content);
	}
}
