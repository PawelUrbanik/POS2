import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DiscriminantListComponent} from "./discriminant-list/discriminant-list.component";
import {HttpClientModule} from "@angular/common/http";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatTableModule} from "@angular/material/table";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatDialogModule} from "@angular/material/dialog";
import {DiscriminantComponent} from './discriminant/discriminant.component';
import {DiscriminantFormComponent} from './discriminant-form/discriminant-form.component';
import {DiscriminantService} from "./discriminant.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FormlyModule} from "@ngx-formly/core";
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [
    DiscriminantListComponent,
    DiscriminantComponent,
    DiscriminantFormComponent
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
    DiscriminantComponent
  ],
  providers: [
    DiscriminantService
  ]
})
export class DiscriminantModule { }
