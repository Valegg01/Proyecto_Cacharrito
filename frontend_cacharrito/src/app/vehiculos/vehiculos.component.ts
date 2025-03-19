import { Component } from '@angular/core';
import { ServicioVehiculoService } from '../servicios/servicio-vehiculo.service';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Vehiculo } from '../Entidades/vehiculo';
import { differenceInDays } from 'date-fns'; 
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-vehiculos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './vehiculos.component.html',
  styleUrl: './vehiculos.component.css'
})
export class VehiculosComponent {
  
  daysDifference: any;
  constructor(private serveh:ServicioVehiculoService, private datepipe:DatePipe){}

  Tipo!: string;

  vehiculo!:Vehiculo[];


  //alquiler

  placa!:string;
  inicio!:Date;
  ninicio!:string;
  final!:Date;
  nfinal!:string;
  cedula!:Date;

  valor!:number

  buscar_tipo(){

    this.serveh.filtro_tipo_estado(this.Tipo,'disponible').subscribe(dato=>{
    
      this.vehiculo=dato;

      if(this.vehiculo.length == 0){

        alert("no hay datos para mostrar")

      }
    
      
    },error=>{
      alert("error al procesar la solicitud")
    })

  }


  alquilar(item:any){

    const mod = document.getElementById("alquilar")

    this.placa=item;
    mod!.style.display='block'
    
  }

  formatearfecha(){

    this.ninicio = this.datepipe.transform(this.inicio,'dd/MM/yyy')||'';
    this.nfinal = this.datepipe.transform(this.final,'dd/MM/yyy')||'';
 
  }
  calcular_dias(){

    if (this.inicio && this.final) {
      const start = new Date(this.inicio);
      const end = new Date(this.final);
      this.daysDifference = differenceInDays(end, start);
    } else {
      this.daysDifference = null;
    }

    this.valor= this.daysDifference!*20000;


  }

}
