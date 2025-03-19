import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {

  constructor(private httpClient: HttpClient) { }
  
    registrar_alquiler(placa:string, fi:string, ff:string, cc:number,valor:number):Observable<any>{
      return this.httpClient.get(`http://localhost:8080/alquiler/registrar?placa=${placa}&inicio=${fi}&final=${ff}&cedula=${cc}&valor=${valor}`)
  
    }

    ver_alquileres():Observable<any>{

       return this.httpClient.get(`http://localhost:8080/alquiler/listaDeAlquileres`)
    }

    
    eliminar(id:number):Observable<any>{

      return this.httpClient.get(`http://localhost:8080/alquiler/cancelarAlquiler?id_Alquiler=${id}`)
   }
}
