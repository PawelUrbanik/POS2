import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {
  OperatingControlPointListComponent
} from "./operating-control-point-list/operating-control-point-list.component";
import {OperatingControlPointComponent} from "./operating-control-point/operating-control-point.component";
import {OperatingControlPointService} from "./operating-control-point.service";
import {MatTableModule} from "@angular/material/table";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FormlyModule} from "@ngx-formly/core";
import {MatButtonModule} from "@angular/material/button";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatDialogModule} from "@angular/material/dialog";
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { OperatingControlPointFormComponent } from './operating-control-point-form/operating-control-point-form.component';
import { OperatingControlPointSearchComponent } from './operating-control-point-search/operating-control-point-search.component';


@NgModule({
  declarations: [
    OperatingControlPointListComponent,
    OperatingControlPointComponent,
    OperatingControlPointFormComponent,
    OperatingControlPointSearchComponent,
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
    MatButtonModule,
    MatProgressSpinnerModule
  ],
  exports: [
    OperatingControlPointComponent
  ],
  providers: [
    OperatingControlPointService
  ]
})
export class OperatingControlPointModule { }
