import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DiscriminantComponent} from "./feature/discriminant/discriminant/discriminant.component";
import {
  OperatingControlPointComponent
} from "./feature/operating-control-point/operating-control-point/operating-control-point.component";
import {TrackComponent} from "./feature/track/track/track.component";
import {DepartmentComponent} from "./feature/department/department/department.component";

const routes: Routes = [
  {
    path: 'discriminants',
    component: DiscriminantComponent,
    title: 'Discriminants'
  },
  {
    path: 'tracks',
    component: TrackComponent,
    title: 'Tracks'
  },
  {
    path: 'operatingPoints',
    component: OperatingControlPointComponent,
    title: 'Control Points'
  },
  {
    path: 'departments',
    component: DepartmentComponent,
    title: 'Departments'
  },
  {
    path: '',
    redirectTo: '/discriminants',
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: '/discriminants',
    pathMatch: 'full'
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
