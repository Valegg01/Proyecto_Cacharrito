import { Usuario } from './usuario';
import { Vehiculo } from './vehiculo';
import { Administrador } from './administrador';
export class Alquiler{
    idAlquiler!:number;
    idUsuario!:Usuario;
    idVehiculo!:Vehiculo;
    idAdmin!:Administrador;
    FechaInicio!:Date;
    fechaFin!:Date;
    estado!:String;
    valor_Total!:number;
}


