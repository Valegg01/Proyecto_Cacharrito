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


      if(dato ==null){

        alert("no hay datos disponibles")


      }else{

        console.log(dato)
        this.vehiculo=dato;

      }
    

    },error=>{
      alert("error al procesar la solicitud")
    })

  }

}
