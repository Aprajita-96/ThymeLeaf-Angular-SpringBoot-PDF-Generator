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
private detailObject:any;

  constructor(private service:PdfgeneratorService) { }

  ngOnInit(): void {
  }
 sub(){
   this.detailObject=
    {
      "name":"Aprajita",
      "age":"22",
      "country":"india"
    }
   console.log("Im here")
   this.service.generatePdf(this.detailObject).subscribe(
    res=>{
      let file = new Blob([res], { type: 'application/pdf' });            
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    });;

 }

}
