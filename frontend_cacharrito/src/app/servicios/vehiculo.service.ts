import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehiculo } from '../Entidades/vehiculo';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {

  private apibuscarVehiculosDisponiblesPorTipo = 'http://localhost:8080/vehiculo/disponiblesPorTipo';
  private apiUrl = 'http://localhost:8080/vehiculo';

  constructor(private HttpClient : HttpClient) {}

  buscarVehiculosDisponiblesPorTipo(tipo: string): Observable<Vehiculo[]> {
   
    return this.HttpClient.get<Vehiculo[]>(`${this.apibuscarVehiculosDisponiblesPorTipo}?tipo=${tipo}`);
  }

  listarVehiculos(): Observable<Vehiculo[]> {
    return this.HttpClient.post<Vehiculo[]>(`${this.apiUrl}/lista`, {});
  }
  
  agregarVehiculo(vehiculo: Vehiculo): Observable<Vehiculo> {
    return this.HttpClient.post<Vehiculo>(`${this.apiUrl}/agregar`, vehiculo);
  }
  
  editarVehiculo(vehiculo: Vehiculo): Observable<Vehiculo> {
    return this.HttpClient.put<Vehiculo>(`${this.apiUrl}/editar`, vehiculo);
  }
  
  eliminarVehiculo(id: number): Observable<void> {
    return this.HttpClient.delete<void>(`${this.apiUrl}/eliminar`, { body: { id_vehiculo: id } }); 
  }
}

