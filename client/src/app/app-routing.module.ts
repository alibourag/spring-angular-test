import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './add/add.component';
import { ArticlesComponent } from './articles/articles.component';
import { OrdersComponent } from './orders/orders.component';

const routes: Routes = [
  {path :'articles', component:ArticlesComponent},
  {path:'articles/add', component: AddComponent},
  {path:'orders', component:OrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
