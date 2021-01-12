import { Label } from "./Label";
import { Band } from "./Band";

export interface Album  {

    name : string,
    label : Label,
    band : Band,
    release_Date : Date,
    style : Style
    
}