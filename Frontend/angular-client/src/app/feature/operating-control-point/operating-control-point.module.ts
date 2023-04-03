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


@NgModule({
  declarations: [
    OperatingControlPointListComponent,
    OperatingControlPointComponent,
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
  exports: [
    OperatingControlPointComponent
  ],
  providers: [
    OperatingControlPointService
  ]
})
export class OperatingControlPointModule { }
