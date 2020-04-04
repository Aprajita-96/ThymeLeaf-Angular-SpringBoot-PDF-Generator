import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrailJsComponent } from './trail-js/trail-js.component';
import { HttpClientModule } from '@angular/common/http';
import { PdfgeneratorService } from './pdfgenerator.service';

@NgModule({
  declarations: [
    AppComponent,
    TrailJsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    PdfgeneratorService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
