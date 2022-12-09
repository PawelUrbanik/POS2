import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


import {MainLayoutComponent} from './layout/main-layout/main-layout.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {FeatureModule} from "./feature/feature.module";


@NgModule({
  declarations: [
    AppComponent,
    MainLayoutComponent,
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatListModule,

    FeatureModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
