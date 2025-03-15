import { Component } from '@angular/core';
import { AdminService } from '../servicios/admin.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-admin',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login-admin.component.html',
  styleUrl: './login-admin.component.css'
})
export class LoginAdminComponent {

  usuario!: string;
  contra!: string;

  constructor(private servicio: AdminService){}

  logueo(){

    this.servicio.buscar_tipo(this.usuario,this.contra).subscribe(dato =>{

      console.log(dato)
      if(dato===true){
        alert("bienvenido")

        window.location.replace("/admin")
      }else{
        alert("usuario o contraseña incorrecta")
      }


    },error=>{
      alert("error al procesar la solicitud")
    })

  }

}
