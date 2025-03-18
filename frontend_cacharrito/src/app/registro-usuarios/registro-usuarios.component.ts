import { Component } from '@angular/core';
import { serviciousuario } from '../servicios/servicio-usuario.service';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-registro-usuarios',
  standalone: true,
  imports: [FormsModule, RouterModule],
  templateUrl: './registro-usuarios.component.html',
  styleUrl: './registro-usuarios.component.css'
})
export class RegistroUsuariosComponent {

  nombre = '';
  num_Iden = '';
  fecha_Exp = '';
  categoria_Licencia = '';
  correo = '';
  telefono = '';
  password = '';

  constructor(private usuarioService : serviciousuario){

  }

  onSubmit(): void {
    const usuario = {
      nombre: this.nombre,
      numIden: this.num_Iden,
      fecha_Exp: this.fecha_Exp,
      categoria_Licencia: this.categoria_Licencia,
      correo: this.correo,
      telefono: this.telefono,
      password: this.password
    };

    this.usuarioService.registrarUsuario(usuario).subscribe(
      (mensaje) => {
        alert(mensaje);
        if (mensaje === 'Usuario regristrado exitosamente.') {
        }
      },
      (error) => {
        alert('Error en el registro: ' + error.message);
      }
    );
  }
}



