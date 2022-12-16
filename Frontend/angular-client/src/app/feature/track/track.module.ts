import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TrackComponent } from './track/track.component';
import {TrackListComponent} from "./track-list/track-list.component";
import {TrackService} from "./track.service";



@NgModule({
  declarations: [
    TrackComponent,
    TrackListComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    TrackComponent
  ],
  providers: [
    TrackService
  ]
})
export class TrackModule { }
