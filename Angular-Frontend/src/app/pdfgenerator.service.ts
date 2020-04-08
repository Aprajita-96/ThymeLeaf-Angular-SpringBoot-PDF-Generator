import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
const httpOptions={
  'responseType' : 'arraybuffer' as 'json'
}
@Injectable({
  providedIn: 'root'
})
export class PdfgeneratorService {

  constructor(private http:HttpClient) { }

  generatePdf(userDetail:any){
    return this.http.post<any>('http://localhost:8080/testapp/getPdf',userDetail,httpOptions)
    
  }
  getdummydata(){
    return this.http.get<any>('http://localhost:8080/testapp/getdumby');
  }
}
