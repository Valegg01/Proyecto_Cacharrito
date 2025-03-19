import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ServicioVehiculoService } from '../servicios/servicio-vehiculo.service';
import { Vehiculo } from '../Entidades/vehiculo';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-administrador',
  standalone: true,
  imports: [CommonModule ,FormsModule],
  templateUrl: './administrador.component.html',
  styleUrl: './administrador.component.css'
})
export class AdministradorComponent {

  constructor(private servicio:ServicioVehiculoService){}

  tipo!:string;
  estado!: string;

  vehiculos!: Vehiculo[];


  filtrar(){

    this.servicio.filtro_tipo_estado(this.tipo,this.estado).subscribe(dato=>{

      if(dato != false){

        this.vehiculos=dato

      }else{
        alert("no se encuentran vehiculo registrados")
      }

    })

  }

  ver_alquiler(){
    
    const alq = document.getElementById("alquiler");
    const veh = document.getElementById("vehiculo");

    alq!.style.display='block';
    veh!.style.display='none';

  }

  ver_vehiculo(){
    

    const alq = document.getElementById("alquiler");
    const veh = document.getElementById("vehiculo");

    alq!.style.display='none';
    veh!.style.display='block';

  }

}
