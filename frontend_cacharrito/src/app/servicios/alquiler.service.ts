import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {

  constructor(private HttpClient:HttpClient) { 
  
    }

     url ='http://localhost:8080/alquiler';
  
    Alquiler(id:number): Observable<any> { 
        return this.HttpClient.get(`${this.url}/buascarid?id_Alquiler=${id}`); 
      }

      elimina(id:number): Observable<any> { 
        return this.HttpClient.get(`${this.url}/eliminar?id_Alquiler=${id}`); 
      }

      actualiza(id:number): Observable<any> { 
        return this.HttpClient.get(`${this.url}/nuevoestado?id_Alquiler=${id}`); 
      }
}
