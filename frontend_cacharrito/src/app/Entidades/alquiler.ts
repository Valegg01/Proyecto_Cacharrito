import { Usuario } from './usuario';
import { Vehiculo } from './vehiculo';
import { Administrador } from './administrador';
export class Alquiler{
    id_Alquiler!:number;
    id_Usuario!:Usuario;
    id_Vehiculo!:Vehiculo;
    id_Admin!:Administrador;
    Fecha_Inicio!:Date;
    estado:string ='';
    valor_Total!:number;
}


