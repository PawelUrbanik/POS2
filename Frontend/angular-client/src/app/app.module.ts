import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DiscriminantListComponent } from './component/discriminant-list/discriminant-list.component';
import { HttpClientModule } from '@angular/common/http'
import { DiscriminantService } from './services/discriminant.service';
import { MatSliderModule } from '@angular/material/slider';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import { TrackListComponent } from './component/track-list/track-list.component'



@NgModule({
  declarations: [
    AppComponent,
    DiscriminantListComponent,
    MainLayoutComponent,
    TrackListComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSliderModule,
    MatPaginatorModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatSidenavModule,
    MatListModule

  ],
  providers: [DiscriminantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
