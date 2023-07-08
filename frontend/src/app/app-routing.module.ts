import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ListPersonsComponent } from './person/list-persons/list-persons.component';

const routes: Routes = [
//  { path: '', component: AppComponent },
//  { path: 'persons', component: ListPersonsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
