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
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import {MatDialogModule} from "@angular/material/dialog";


@NgModule({
  declarations: [FormlyFieldTabs, CustomPlatformTableComponent, ConfirmationDialogComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatTabsModule,
    FormlyModule,
    FormsModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    PlatformModule,
    MatDialogModule
  ]
})
export class CoreModule { }
