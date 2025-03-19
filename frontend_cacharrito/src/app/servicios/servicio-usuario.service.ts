import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class serviciousuario {

  private apiURL = 'http://localhost:8080/usuario/registroUsuario'
  private apiURLLogin = 'http://localhost:8080/usuario/usuarioLogin'

  constructor(private HttpClient:HttpClient) { 

  }

  registrarUsuario(usuario: any): Observable<string> { 
      return this.HttpClient.post(this.apiURL, usuario, { responseType: 'text' }); 
    }

    login(numIden: number, password: string): Observable<string> {
      return this.HttpClient.post(this.apiURLLogin, { numIden, password }, { responseType: 'text' });
  }

}


  


