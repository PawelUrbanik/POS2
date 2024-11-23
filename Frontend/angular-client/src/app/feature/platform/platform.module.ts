import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlatformComponent } from './platform.component';
import { PlatformFormComponent } from './platform-form/platform-form.component';
import {FormlyModule} from "@ngx-formly/core";
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatTableModule} from "@angular/material/table";
import {PlatformService} from "./platform.service";



@NgModule({
  declarations: [
    PlatformComponent,
    PlatformFormComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MatPaginatorModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    ReactiveFormsModule,
    FormlyModule,
    FormsModule,
    MatButtonModule
  ],
  providers: [
    PlatformService
  ],
  exports: [
    PlatformComponent
  ]
})
export class PlatformModule { }
