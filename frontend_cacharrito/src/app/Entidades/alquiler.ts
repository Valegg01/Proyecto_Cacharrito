import { Usuario } from './usuario';
import { Vehiculo } from './vehiculo';
import { Administrador } from './administrador';
export class Alquiler{
    id_Alquiler!:number;
    id_Usuario!:Usuario;
    id_Vehiculo!:Vehiculo;
    id_Admin!:Administrador;
    FechaInicio!:Date;
    fechaFin!:Date;
    estado!:String;
    valor_Total!:number;
}


