import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BandsComponent } from './TablesComponents/bands/bands.component';
import { AlbumsComponent } from './TablesComponents/albums/albums.component';
import { LabelsComponent } from './TablesComponents/labels/labels.component';
import { MembersComponent } from './TablesComponents/members/members.component';

const routes: Routes = [
  { path: "albums", component: AlbumsComponent},
  { path: "bands", component: BandsComponent},
  { path: "labels", component: LabelsComponent},
  { path: "members", component: MembersComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
