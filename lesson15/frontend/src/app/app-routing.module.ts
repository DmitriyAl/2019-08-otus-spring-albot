import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OrdersComponent} from "./orders/orders.component";
import {ProductsComponent} from "./products/products.component";


const routes: Routes = [
  {path: 'orders', component: OrdersComponent},
  {path: 'products', component: ProductsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
