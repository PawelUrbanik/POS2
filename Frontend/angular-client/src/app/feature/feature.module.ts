import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DiscriminantModule} from "./discriminant/discriminant.module";
import {OperatingControlPointModule} from "./operating-control-point/operating-control-point.module";
import {TrackModule} from "./track/track.module";



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    DiscriminantModule,
    OperatingControlPointModule,
    TrackModule
  ]
})
export class FeatureModule { }
