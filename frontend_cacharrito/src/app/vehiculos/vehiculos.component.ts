import { Component } from '@angular/core';
import { ServicioVehiculoService } from '../servicios/servicio-vehiculo.service';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Vehiculo } from '../Entidades/vehiculo';

@Component({
  selector: 'app-vehiculos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './vehiculos.component.html',
  styleUrl: './vehiculos.component.css'
})
export class VehiculosComponent {
  constructor(private serveh:ServicioVehiculoService){}

  Tipo!: string;

  vehiculo!:Vehiculo[];

 

  buscar_tipo(){

    this.serveh.buscar_tipo(this.Tipo).subscribe(dato=>{
    
      this.vehiculo=dato;

      if(this.vehiculo.length == 0){

        alert("no hay datos para mostrar")

      }
    
      
    },error=>{
      alert("error al procesar la solicitud")
    })

  }

}
