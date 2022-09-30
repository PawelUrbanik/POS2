import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DiscriminantListComponent } from './component/discriminant-list/discriminant-list.component';
import { HttpClientModule } from '@angular/common/http'
import { DiscriminantService } from './services/discriminant.service';

@NgModule({
  declarations: [
    AppComponent,
    DiscriminantListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [DiscriminantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
