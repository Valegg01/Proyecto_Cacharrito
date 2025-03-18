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

  buscarVehiculosDisponiblesPorTipo(tipo: string, fechaInicio: Date | undefined, fechaFin: Date | undefined): Observable<Vehiculo[]> {
    let params = new HttpParams();
    if (tipo) {
        params = params.set('tipo', tipo);
    }
    if (fechaInicio) {
        params = params.set('fechaInicio', fechaInicio.toISOString().split('T')[0]);
    }
    if (fechaFin) {
        params = params.set('fechaFin', fechaFin.toISOString().split('T')[0]);
    }
    return this.HttpClient.get<Vehiculo[]>(this.apibuscarVehiculosDisponiblesPorTipo + 'disponiblesPorTipo', { params });
  }
}

