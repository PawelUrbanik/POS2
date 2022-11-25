import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DiscriminantComponent} from "./feature/discriminant/discriminant/discriminant.component";
import {
  OperatingControlPointComponent
} from "./feature/operating-control-point/operating-control-point/operating-control-point.component";
import {TrackComponent} from "./feature/track/track/track.component";

const routes: Routes = [
  {path: 'discriminants', component: DiscriminantComponent},
  {path: 'tracks', component: TrackComponent},
  {path: 'operatingPoints', component: OperatingControlPointComponent},
  {path: '', redirectTo:'/discriminants', pathMatch:'full'},
  {path: '**', redirectTo:'/discriminants', pathMatch:'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
