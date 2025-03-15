import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehiculo } from '../Entidades/vehiculo';

@Injectable({
  providedIn: 'root'
})
export class ServicioVehiculoService {

  constructor(private httpClient: HttpClient) { }

  buscar_tipo(Tipo:string):Observable<any>{
    return this.httpClient.get(`http://localhost:8080/vehiculo/Tipo?Tipo=${Tipo}`)

  }

  filtro_tipo_estado(Tipo:string, filtro:string):Observable<any>{
    return this.httpClient.get(`http://localhost:8080/vehiculo/filtro?filtro=${filtro}&tipo=${Tipo}`)
  }
}
