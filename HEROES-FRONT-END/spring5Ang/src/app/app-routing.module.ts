import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeroesComponent } from './heroes/heroes.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';


//  AppRoutingModule.Routes array.
// The colon (:) in the path indicates that :id is a placeholder for a specific hero id.
const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: HeroDetailComponent },
  { path: 'heroes', component: HeroesComponent }
];

// The @NgModule metadata initializes the router and starts it listening for browser location changes.
// The following line adds the RouterModule to the AppRoutingModule imports array and configures it with 
// the routes in one step by calling RouterModule.forRoot():

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }