import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DiscriminantListComponent } from './component/discriminant-list/discriminant-list.component';
import { TrackListComponent } from './component/track-list/track-list.component';

const routes: Routes = [
  {path: 'discriminants', component: DiscriminantListComponent},  
  {path: 'tracks', component: TrackListComponent},
  {path: '', redirectTo:'/discriminants', pathMatch:'full'},
  {path: '**', redirectTo:'/discriminants', pathMatch:'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
