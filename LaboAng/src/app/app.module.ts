import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientJsonpModule, HttpClientModule, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, HttpClientModule, HttpClientJsonpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
