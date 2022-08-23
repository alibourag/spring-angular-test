import { Component, OnInit } from '@angular/core';
import { Article } from '../models/Article';
import { ArticleService } from '../service/article.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

  orders : any[]= []

  constructor(public articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleService.getAllOrders().subscribe((re) => {
      this.orders =  re
    })
  }

}
