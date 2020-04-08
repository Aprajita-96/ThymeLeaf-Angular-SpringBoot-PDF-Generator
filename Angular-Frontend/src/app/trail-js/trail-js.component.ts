import {  OnInit } from '@angular/core';
import { Component } from '@angular/core';
import {PdfgeneratorService} from '../pdfgenerator.service';

@Component({
  selector: 'app-trail-js',
  templateUrl: './trail-js.component.html',
  styleUrls: ['./trail-js.component.css']
})
export class TrailJsComponent implements OnInit {
  // @ViewChild('content') content: ElementRef;
private name :string="appu";
detailObject: Details = {
  name:'',
  age:'',
  country:''
  };


  constructor(private service:PdfgeneratorService) { }

  ngOnInit(): void {
    this.service.getdummydata().subscribe(res=>{
      let result:any=res;
      this.detailObject.name=result.name;
      this.detailObject.age=result.age;
      this.detailObject.country=result.country;
      console.log(this.detailObject)
    })
  }
 sub(){
   
   console.log("Im here")

   this.service.generatePdf(this.detailObject).subscribe(
    res=>{
      let file = new Blob([res], { type: 'application/pdf' });            
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    });;

 }

}
interface Details
{
name:string;
age:string;
country:string;
}
