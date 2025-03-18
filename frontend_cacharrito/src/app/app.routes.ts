import { Routes } from '@angular/router';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { AdministradorComponent } from './administrador/administrador.component';
import { RegistroUsuariosComponent } from './registro-usuarios/registro-usuarios.component';
import { LoginUsuarioComponent } from './login-usuario/login-usuario.component';

export const routes: Routes = [

    {path: "vehiculos", component:RegistroUsuariosComponent},
    {path: "LoguinAdmin", component:LoginAdminComponent},
    {path: "admin", component:AdministradorComponent},
    {path: "login", component: LoginUsuarioComponent },

];

  