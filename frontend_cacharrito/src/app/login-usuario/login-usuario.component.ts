import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { serviciousuario } from '../servicios/servicio-usuario.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login-usuario',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login-usuario.component.html',
  styleUrl: './login-usuario.component.css'
})
export class LoginUsuarioComponent {

  correo = '';
  password = '';
  mensajeError = '';

  constructor(private usuarioService: serviciousuario) { 

  }

  onSubmit(): void {
    this.usuarioService.login(this.correo, this.password).subscribe(
      (mensaje) => {
        if (mensaje === 'Login exitoso.') {
          console.log('Login exitoso:', mensaje);
        } else {
          this.mensajeError = mensaje; 
          console.error('Error de login:', mensaje);
        }
      },
      (error) => {
        this.mensajeError = 'Error de conexión con el servidor.';
        console.error('Error de conexión:', error);
      }
    );
  }
}

