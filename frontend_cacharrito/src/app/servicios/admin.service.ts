import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient: HttpClient) { }

  URL ="http://localhost:8080/admin/"

  buscar_tipo(usuario:string, clave:string ):Observable<any>{
      return this.httpClient.get(`${this.URL}?usuario=${usuario}&Password=${clave}`)
    }
}
