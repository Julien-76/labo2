import { Label } from "./Label";
import { Band } from "./Band";
import { DatePipe } from "@angular/common";

export interface Album  {

    name : string,
    label : Label,
    band : Band,
    release_Date : Date,
    style : any
    
}