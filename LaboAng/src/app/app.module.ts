import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientJsonpModule, HttpClientModule, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormBuilder, FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BandsComponent } from './TablesComponents/bands/bands.component';
import { AlbumsComponent } from './TablesComponents/albums/albums.component';
import { LabelsComponent } from './TablesComponents/labels/labels.component';
import { MembersComponent } from './TablesComponents/members/members.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import { formatDate } from '@angular/common';



@NgModule({
  declarations: [
    AppComponent,
    BandsComponent,
    AlbumsComponent,
    LabelsComponent,
    MembersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, HttpClientModule, HttpClientJsonpModule, ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
