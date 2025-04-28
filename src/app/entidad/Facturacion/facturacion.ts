import { Clientes } from "../clientes/clientes";
import { ServicioInmediato } from "../servicioInmediato/servicio-inmediato";

export class Facturacion {

    total !: number;
    fechaEmision !: Date;
    detalles !: string;
    cliente !: Clientes;
    servicioInmediato !: ServicioInmediato;

}
