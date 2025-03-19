import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Vehiculo } from '../Entidades/vehiculo';
import { VehiculoService } from '../servicios/vehiculo.service';

@Component({
  selector: 'app-gestionvehiculos',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './gestionvehiculos.component.html',
  styleUrl: './gestionvehiculos.component.css'
})
export class GestionvehiculosComponent implements OnInit {

  vehiculos: Vehiculo[] = [];
  nuevoVehiculo: Vehiculo = new Vehiculo(); 
  vehiculoSeleccionado: Vehiculo = new Vehiculo(); 
  modoEdicion = false;

  constructor(private vehiculoService: VehiculoService) { }

  ngOnInit(): void {
    this.listarVehiculos();
  }

  listarVehiculos = (): void => { 
    this.vehiculoService.listarVehiculos().subscribe(vehiculos => this.vehiculos = vehiculos);
  }
  
  agregarVehiculo = (): void => { 
    this.vehiculoService.agregarVehiculo(this.nuevoVehiculo).subscribe(() => {
      this.listarVehiculos();
      this.nuevoVehiculo = new Vehiculo();
    });
  }

  seleccionarVehiculo(vehiculo: Vehiculo): void {
    this.vehiculoSeleccionado = { ...vehiculo };
    this.modoEdicion = true;
  }

  editarVehiculo(): void {
    this.vehiculoService.editarVehiculo(this.vehiculoSeleccionado).subscribe(() => {
      this.listarVehiculos();
      this.vehiculoSeleccionado = new Vehiculo();
      this.modoEdicion = false;
    });
  }

  eliminarVehiculo(id: number): void {
    this.vehiculoService.eliminarVehiculo(id).subscribe(() => this.listarVehiculos());
  }
}
  
