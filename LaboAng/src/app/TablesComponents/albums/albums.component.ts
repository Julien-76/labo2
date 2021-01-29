import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validator, Validators } from '@angular/forms';
import { Label } from '../../Tables/Label';
import { Band } from '../../Tables/Band';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { formatDate } from '@angular/common';

import { Album } from 'src/app/Tables/Album';
import { JsonPipe } from '@angular/common';
import { jsDocComment } from '@angular/compiler';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.scss']
})
export class AlbumsComponent implements OnInit {

  
  newAlbum : Album;
  create : boolean = false;
  delete : boolean = false;
  update : boolean = false;


  listeLabels : Array<Label> = [];
  listeBands : Array<Band> = [];

  formulCreateAlbum : FormGroup;
  constructor(private formBuilder: FormBuilder, private httpClient: HttpClient) {
    this.formulCreateAlbum = formBuilder.group({
       name: new FormControl("", [Validators.required]),
       label: new FormControl("", [Validators.required]),
       band: new FormControl("", [Validators.required]),
       release_Date: new FormControl("", [Validators.required]),
       style: new FormControl("",  [Validators.required])
    })
  }


  onCreate() {
    if (this.formulCreateAlbum.invalid) {
      alert("Formulaire invalide")
      console.log(this.formulCreateAlbum)
    } else {
      this.newAlbum = this.formulCreateAlbum.value;
      
      console.log('album créé : ' +  this.newAlbum);
      this.httpClient
      .post('http://localhost:8080/Labo2/api/albums', this.newAlbum)
      .subscribe(
        () => {
          console.log('Album rajouté !');
        },
        (error) => {
          console.log('Erreur ! : ' + error);
        }
      );
    }
  }
  toApiDate(bDate) {
    const apiDate: string = new Date(bDate).toUTCString();
    return apiDate;
  } 



  ngOnInit(): void {
  }

  
  deleteOk() {
    this.delete = true;
    this.create = true;
    this.update = false;
  }
  updateOk() {
    this.delete = true;
    this.create = true;
    this.update = true;
  }

  getApi() {
    this.delete = false;
    this.create = true;
    this.update = false;
    this.httpClient.get<Label[]>('http://localhost:8080/Labo2/api/labels')
    .subscribe(
      (response) => {
        this.listeLabels = response;
        console.log("Ca passe au moins...")
      },
      (error) => {
        console.log('On y est pas encore mais on va y arriver !' + error)
      }
    )
    this.httpClient.get<Band[]>('http://localhost:8080/Labo2/api/bands')
    .subscribe(
      (response) => {
        this.listeBands = response;
        console.log("Ca passe au moins...")
      },
      (error) => {
        console.log('On y est pas encore mais on va y arriver !' + error);
      }
    )
  }
}
