import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-administrador',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './administrador.component.html',
  styleUrl: './administrador.component.css'
})
export class AdministradorComponent {

  

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
