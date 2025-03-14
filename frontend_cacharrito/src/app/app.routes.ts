import { Routes } from '@angular/router';
import { VehiculosComponent } from './vehiculos/vehiculos.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';

export const routes: Routes = [

    {path: "vehiculos", component:VehiculosComponent},
    {path: "LoguinAdmin", component:LoginAdminComponent},

];
