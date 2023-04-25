import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormlyFieldTabs} from "./components/FormlyFieldTabs.type";
import {MatTabsModule} from "@angular/material/tabs";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FormlyModule} from "@ngx-formly/core";


@NgModule({
  declarations: [FormlyFieldTabs],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatTabsModule,
    FormlyModule,
    FormsModule
  ]
})
export class CoreModule { }
