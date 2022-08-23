import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable, Subscriber } from 'rxjs';
import { ArticleService } from '../service/article.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent implements OnInit {
  articles : any[]=[]

  constructor( private articleService: ArticleService) { 
    
  }

  ngOnInit(): void {
     this.articleService.getll().subscribe((res)=>{
      this.articles=res
      console.log("ok"+res);
     })
  }
  
}
