import { Component } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Label } from './Tables/Label';
import { Band } from './Tables/Band';
import { Album } from './Tables/Album';
import { Member } from './Tables/Member';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
  
})
@Injectable()
export class AppComponent {

  constructor(private httpClient : HttpClient) {

  }
  choix : string;
  listeLabels : Array<Label> = [];
  listeAlbums : Array<Album> = [];
  listeBands : Array<Band> = [];
  listeMembers : Array<Member> = [];
  headTabLab : Boolean = false;

  configUrl = 'http://localhost:8080/Labo2/api/labels';

  getLabels() {
    this.headTabLab = true;
    this.httpClient.get<Label[]>('http://localhost:8080/Labo2/api/labels')
    .subscribe(
      (response) => {
        this.listeLabels = response;
      },
      (error) => {
        console.log('On y est pas encore mais on va y arriver !' + error)
      }
    );
  }



  getBands() {
    this.httpClient.get<Band[]>('http://localhost:8080/Labo2/api/bands')
    .subscribe(
      (response) => {
        this.listeBands = response;
      },
      (error) => {
        console.log('On y est pas encore mais on va y arriver !' + error)
      }
    );
  }

  getAlbums() {
    this.httpClient.get<Album[]>('http://localhost:8080/Labo2/api/albums')
    .subscribe(
      (response) => {
        this.listeAlbums = response;
      },
      (error) => {
        console.log('On y est pas encore mais on va y arriver !' + error)
      }
    );
  }

  getMembers() {
    this.httpClient.get<Member[]>('http://localhost:8080/Labo2/api/members')
    .subscribe(
      (response) => {
        this.listeMembers = response;
      },
      (error) => {
        console.log('On y est pas encore mais on va y arriver !' + error)
      }
    );
  }

  closeAlbums() {
    this.listeAlbums = [];
  }

  closeLabels() {
    this.listeLabels = [];
  }

  closeBands() {
    this.listeBands = [];
  }

  closeMembers() {
    this.listeMembers = [];
  }

  choixAlbums() {
    this.choix = 'albums'
  }

  choixBands() {
    this.choix = 'bands'
  }

  choixLabels() {
    this.choix = 'labels'
  }

  choixMembers() {
    this.choix = 'members'
  }
}
