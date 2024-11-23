import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormlyFieldTabs} from "./components/FormlyFieldTabs.type";
import {MatTabsModule} from "@angular/material/tabs";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FormlyModule} from "@ngx-formly/core";
import {CustomPlatformTableComponent} from "./components/CustomPlatformTableComponent";
import {MatTableModule} from "@angular/material/table";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {PlatformModule} from "../feature/platform/platform.module";


@NgModule({
  declarations: [FormlyFieldTabs, CustomPlatformTableComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatTabsModule,
    FormlyModule,
    FormsModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    PlatformModule
  ]
})
export class CoreModule { }
