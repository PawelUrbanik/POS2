import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


import {MainLayoutComponent} from './layout/main-layout/main-layout.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {FeatureModule} from "./feature/feature.module";
import {FormlyModule} from "@ngx-formly/core";
import {FormlyMaterialModule} from "@ngx-formly/material";
import {MatIconModule} from "@angular/material/icon";
import {FORM_CONFIG} from "./core/form-config";
import {CoreModule} from "./core/core.module";



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
    FormlyModule.forRoot(FORM_CONFIG),
    FormlyMaterialModule,
    MatIconModule,

    FeatureModule,
    CoreModule



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
