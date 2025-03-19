import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Vehiculo } from '../Entidades/vehiculo';
import { VehiculoService } from '../servicios/vehiculo.service';
import { AuthService } from '../servicios/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-buscarvehiculos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './buscarvehiculos.component.html',
  styleUrl: './buscarvehiculos.component.css'
})
export class BuscarvehiculosComponent implements OnInit {

  tipo: string = '';
  vehiculos: Vehiculo[] = [];
  mensajeError: string = '';

  constructor(private vehiculoService: VehiculoService, private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
  }

  buscarVehiculos() {
    if (!this.tipo) {
        this.mensajeError = 'Por favor, selecciona un tipo de vehículo.';
        return;
    }
    this.vehiculoService.buscarVehiculosDisponiblesPorTipo(this.tipo).subscribe(
        (vehiculos) => {
            this.vehiculos = vehiculos;
            this.mensajeError = '';
            if (vehiculos.length === 0) {
                this.mensajeError = 'No se encontraron vehículos disponibles con los filtros seleccionados.';
            }
        },
        (error) => {
            console.error('Error al buscar vehículos:', error);
            this.mensajeError = 'Error al buscar vehículos. Por favor, inténtalo de nuevo más tarde.';
        }
    );
  }
}