import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { serviciousuario } from '../servicios/servicio-usuario.service';
import { CommonModule } from '@angular/common';
import { AuthService } from '../servicios/auth.service';
import { Router } from '@angular/router';

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

  constructor(private usuarioService: serviciousuario, private authService: AuthService, private router: Router) {} // Inyecta AuthService y Router

  onSubmit(): void {
    this.authService.login(this.correo, this.password).subscribe(
        (mensaje) => {
            if (mensaje === 'Login exitoso.') {
              console.log(mensaje)
                //this.router.navigate(['/buscar-vehiculos']);
                window.location.replace('/buscarvehiculos')
            } else {
                this.mensajeError = 'Credenciales inválidas.';
            }
        },
        (error) => {
            this.mensajeError = 'Error de conexión con el servidor.';
            console.error('Error de conexión:', error);
        }
    );
  }
}



