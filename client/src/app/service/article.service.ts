import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { articles } from "src/data";
import { Article } from "../models/Article";
import {HttpClient, HttpEvent, HttpRequest} from '@angular/common/http'
@Injectable({
    providedIn : 'root'
})
export class ArticleService{

    imagePreviewSrc: string | ArrayBuffer | null | undefined = '';
    isImageSelected: boolean = false;
    constructor(private http : HttpClient){}

    url:string ="http://localhost:8080"

    getll():Observable<any>{
        return this.http.get(this.url+"/articles");
    }
    getAllOrders():Observable<any>{
        return this.http.get(this.url+"/orders");
    }

    saveArticle(file: File,name:string,price:any): Observable<HttpEvent<any>> {
        const formData: FormData = new FormData();
    
        formData.append('file', file);
        formData.append('name',name);
        formData.append('price', price);
       

        const req = new HttpRequest('POST', `${this.url}/articles`, formData,{
          responseType: 'json'
        });

        return this.http.request(req)
    }
    showPreview(event: Event) {
        let selectedFile = (event.target as HTMLInputElement).files?.item(0)
    
        if (selectedFile) {
          if (["image/jpeg", "image/png", "image/svg+xml"].includes(selectedFile.type)) {
            let fileReader = new FileReader();
            fileReader.readAsDataURL(selectedFile);
    
            fileReader.addEventListener('load', (event) => {
              this.imagePreviewSrc = event.target?.result;
              this.isImageSelected = true
            })
          }
        } else {
          this.isImageSelected = false
        }
      }

}