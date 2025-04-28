import { Clientes } from "../clientes/clientes";
import { PlanesFuturos } from "../planesFuturuos/planes-futuros";

export class Recordatorios {

    fechaEnvio !: Date;
    estadoEnvio !: string;
    cliente !: Clientes;
    planes !: PlanesFuturos;

}
