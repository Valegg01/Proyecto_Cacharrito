import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehiculo } from '../Entidades/vehiculo';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {

  private apibuscarVehiculosDisponiblesPorTipo = 'http://localhost:8080/vehiculo/disponiblesPorTipo';

  constructor(private HttpClient : HttpClient) {}

  buscarVehiculosDisponiblesPorTipo(tipo: string): Observable<Vehiculo[]> {
    let params = new HttpParams();
    if (tipo) {
        params = params.set('tipo', tipo);
    }
    return this.HttpClient.get<Vehiculo[]>(this.apibuscarVehiculosDisponiblesPorTipo + 'disponiblesPorTipo', { params });
}
}

