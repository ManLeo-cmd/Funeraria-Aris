import { Clientes } from "../clientes/clientes";

export class PlanesFuturos {

    id_plan !: number;
    nombre !: string;
    costo !: number;
    mensualidades !: number;
    mesesPagados !: number;
    saldoRestante !: number;
    cliente !: Clientes;

}
