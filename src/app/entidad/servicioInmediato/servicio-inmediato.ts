import { Clientes } from "../clientes/clientes";
import { Facturacion } from "../Facturacion/facturacion";

export class ServicioInmediato {

    nombre !: string;
    edad !: number;
    fechaDefuncion !: Date;
    causaMuerte !: string;
    tipoServicio !: string;
    cliente !: Clientes;
    factura !: Facturacion;

}
