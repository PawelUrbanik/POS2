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





@NgModule({
  declarations: [
    AppComponent,
    DiscriminantListComponent
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
    MatInputModule
  ],
  providers: [DiscriminantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
