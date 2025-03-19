import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { serviciousuario } from './servicio-usuario.service';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    private isAuthenticatedSubject = new BehaviorSubject<boolean>(false);

    constructor(private router: Router, private usuarioService: serviciousuario) {}

    login(numIden: number, password: string): Observable<string> {
        return new Observable<string>((observer) => {
            this.usuarioService.login(numIden, password).subscribe(
                (mensaje) => {
                    if (mensaje === 'Login exitoso.') {
                        this.isAuthenticatedSubject.next(true);
                    } else {
                        this.isAuthenticatedSubject.next(false);
                    }
                    observer.next(mensaje);
                    observer.complete();
                },
                (error) => {
                    this.isAuthenticatedSubject.next(false);
                    observer.error(error);
                }
            );
        });
    }

    logout() {
        this.isAuthenticatedSubject.next(false);
        this.router.navigate(['/login']);
    }

    isAuthenticated(): boolean {
        return this.isAuthenticatedSubject.value;
    }
}