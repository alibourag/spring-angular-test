import { Component, OnInit} from '@angular/core';
import { Article } from '../models/Article';
import { ArticleService } from '../service/article.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  article : Article = new  Article();
  selectedFile !: File ;
  currentFile?: File;

  constructor( private articleService: ArticleService) { }

  ngOnInit(): void {
  }
 
onFileChanged(event: any ){
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.selectedFile = file;
      }
  }
  sendData(){
    if(this.selectedFile){
      const file: File | null = this.selectedFile;
      if (file) {
        this.currentFile = file;
        this.articleService.saveArticle(this.currentFile, this.article.name, this.article.price).subscribe((res)=>{
          alert("Add successful")
        })
      }
    }
  }
  onSubmit(){
    this.sendData()
  }
}
