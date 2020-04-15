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
  public arrayresponse=[];


  constructor(private service:PdfgeneratorService) { }

  ngOnInit(): void {
    this.service.getdummydata().subscribe(res=>{
      let result:any=res;

      // this.detailObject.name=result.name;
      // this.detailObject.age=result.age;
      // this.detailObject.country=result.country;
      // console.log(this.detailObject)
      this.arrayresponse=result;
      console.log(this.arrayresponse)
    })
  }
 sub(){
   
   console.log("Im here")

   this.service.generatePdf(this.arrayresponse).subscribe(
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
