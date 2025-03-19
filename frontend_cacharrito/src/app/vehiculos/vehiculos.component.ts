import { Component, OnInit } from '@angular/core';
import { ServicioVehiculoService } from '../servicios/servicio-vehiculo.service';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Vehiculo } from '../Entidades/vehiculo';
import { differenceInDays } from 'date-fns'; 
import { DatePipe } from '@angular/common';
import { AlquilerService } from '../servicios/alquiler.service';
import { Alquiler } from '../Entidades/alquiler';

import jsPDF from 'jspdf';

@Component({
  selector: 'app-vehiculos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  providers:[DatePipe],
  templateUrl: './vehiculos.component.html',
  styleUrl: './vehiculos.component.css'
})
export class VehiculosComponent implements OnInit{
  
  daysDifference: any;
  constructor(private serveh:ServicioVehiculoService, private datepipe:DatePipe, private seralq: AlquilerService){}

  ngOnInit(): void {
    this.ver_lista()
  }

  Tipo!: string;

  vehiculo!:Vehiculo[];


  //alquiler

  placa!:string;
  inicio!:Date;
  ninicio!:string;
  final!:Date;
  nfinal!:string;
  cedula!:number;

  valor!:number

  alquiler: Alquiler= new Alquiler;

  alquileres!: Alquiler[];

  ver_lista(){
    this.seralq.ver_alquileres().subscribe(dato=>{
      this.alquileres =dato;
    })
  }

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
    this.valor_dias()
 
  }

  valor_dias(){

    if (this.inicio && this.final) {
      const start = new Date(this.inicio);
      const end = new Date(this.final);
      this.daysDifference = differenceInDays(end, start);
    } else {
      this.daysDifference = null;
    }

    this.valor= this.daysDifference!*20000;


  }

  registrar(){
    
    this.seralq.registrar_alquiler(this.placa, this.ninicio, this.nfinal, this.cedula, this.valor).subscribe(dato=>{


      if(dato){

        this.alquiler = dato;
        
        console.log(this.alquiler)

        alert("registro exitoso")

        this.generarpdf()

        window.location.reload()

      }else{
        alert("hubo un error")
      }

    }, (error) =>{
      alert(" por favor revise que su identificacion sea correcta, si el problema persiste comuniquese con los desarrolladores")
      console.log(error)
    })
  }

  generarpdf(){

    const doc = new jsPDF()


    doc.text(`Mi Cacharrito"`,20,10)
    doc.text(`informacion del su alquiler:"`,20,20)
    doc.text(`id del alquiler = ${this.alquiler.idAlquiler}`,20,30)
    doc.text(`fecha de inicio =${this.alquiler.FechaInicio}`,20,40)
    doc.text(`fecha de final =${this.alquiler.fechaFin}`,20,50)
    /*doc.text(`placa del vehiculo= ${this.alquiler.idVehiculo.placa}`,20,60)
    doc.text(`tipo = ${this.alquiler.idVehiculo.tipo}`,20,70)
    doc.text(`color = ${this.alquiler.idVehiculo.color}`,20,80)
    doc.text(`A nombre de = ${this.alquiler.idUsuario.nombre}`,20,90)*/

    doc.save(`alquiler_.pdf`)


  }

}
