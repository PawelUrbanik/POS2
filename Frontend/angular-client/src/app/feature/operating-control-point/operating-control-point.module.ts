import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {
  OperatingControlPointListComponent
} from "./operating-control-point-list/operating-control-point-list.component";
import {OperatingControlPointComponent} from "./operating-control-point/operating-control-point.component";
import {OperatingControlPointService} from "./operating-control-point.service";


@NgModule({
  declarations: [
    OperatingControlPointListComponent,
    OperatingControlPointComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    OperatingControlPointComponent
  ],
  providers: [
    OperatingControlPointService
  ]
})
export class OperatingControlPointModule { }
