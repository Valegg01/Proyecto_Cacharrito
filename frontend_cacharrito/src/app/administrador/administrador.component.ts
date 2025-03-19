import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ServicioVehiculoService } from '../servicios/servicio-vehiculo.service';
import { Vehiculo } from '../Entidades/vehiculo';
import { FormsModule } from '@angular/forms';
import { Alquiler } from '../Entidades/alquiler';
import { AlquilerService } from '../servicios/alquiler.service';

@Component({
  selector: 'app-administrador',
  standalone: true,
  imports: [CommonModule ,FormsModule],
  templateUrl: './administrador.component.html',
  styleUrl: './administrador.component.css'
})
export class AdministradorComponent {

  constructor(private servicio:ServicioVehiculoService, private seralquiler : AlquilerService){}

  tipo!:string;
  estado!: string;

  vehiculos!: Vehiculo[];

  alquileres!: Alquiler;

  id!:number;


  filtrar(){

    this.servicio.filtro_tipo_estado(this.tipo,this.estado).subscribe(dato=>{

      if(dato != false){

        this.vehiculos=dato

      }else{
        alert("no se encuentran vehiculo registrados")
      }

    })

  }

  buscaid(){

    this.seralquiler.Alquiler(this.id).subscribe(data =>{
      if(data){
        console.log(data)
        this.alquileres = data
      }else{
        alert("no se ebncontraron datos")
      }
    },(error)=>{
      alert ("error de respuesta del servidor")
      console.error(error)
    })

   
  }

  eliminar(){
    this.seralquiler.elimina(this.alquileres.id_Alquiler).subscribe(data=>{
      if(data){
        alert("se elimino exitosamente")
        window.location.reload()
      }else{
        alert("error al eliminar el alquiler")
      }
    },(error)=>{
      alert("error de respuesta del servidor")
      console.error(error)
    })
  }

  actaulizar(){
    this.seralquiler.actualiza(this.alquileres.id_Alquiler).subscribe(data=>{
      if(data){
        alert("se aprobo exitosamente")
        window.location.reload()
      }else{
        alert("error al eliminar el alquiler")
      }
    },(error)=>{
      alert("error de respuesta del servidor")
      console.error(error)
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
