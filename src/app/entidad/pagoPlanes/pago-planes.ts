import { PlanesFuturos } from "../planesFuturuos/planes-futuros";

export class PagoPlanes {

    id !: number;
    noPago !: number;
    fechaPago !: Date;
    monto !: number;
    pagado !: boolean;
    planes !: PlanesFuturos;
}
