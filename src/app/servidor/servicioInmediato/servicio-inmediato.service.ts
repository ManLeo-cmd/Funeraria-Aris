import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Clientes } from '../../entidad/clientes/clientes';
import { ServicioInmediato } from '../../entidad/servicioInmediato/servicio-inmediato';
import { PersonalizacionServicios } from '../../entidad/PersonalizacionServicios/personalizacion-servicios';
import { Facturacion } from '../../entidad/Facturacion/facturacion';
import { PlanesFuturos } from '../../entidad/planesFuturuos/planes-futuros';
import { PagoPlanes } from '../../entidad/pagoPlanes/pago-planes';
import { Recordatorios } from '../../entidad/recordatorios/recordatorios';

@Injectable({
  providedIn: 'root'
})
export class ServicioInmediatoService {

  constructor(private http : HttpClient) {}

  url = "http://localhost:8080/";

  guardar(token : string | null, serv : ServicioInmediato){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<any>(this.url + "servicio" + "/guardar",  serv ,{headers : httpHeaders});
  }

  guardarPersonalizacion(token : string | null, serv : PersonalizacionServicios){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<any>(this.url + "personalizacion" + "/guardar",  serv ,{headers : httpHeaders});
  }

  guardarFact(token : string | null, serv : Facturacion){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<any>(this.url + "personalizacion" + "/guardar",  serv ,{headers : httpHeaders});
  }

  guardarPlanes(token : string | null, serv : PlanesFuturos){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<any>(this.url + "planes" + "/guardar",  serv ,{headers : httpHeaders});
  }

  buscarPlanCliente(token : string | null, serv : number){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.get<PlanesFuturos[]>(this.url + "planes" + "/buscar/cliente/" + serv ,{headers : httpHeaders});
  }


  buscarPagosPlan(token : string | null, serv : number){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.get<PagoPlanes[]>(this.url + "pagos" + "/buscar/planes/" + serv ,{headers : httpHeaders});
  }

  buscarUltimoPago(token : string | null, serv : number){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.get<PagoPlanes>(this.url + "pagos" + "/nopagado/" + serv ,{headers : httpHeaders});
  }

  guardarPagos(token : string | null, serv : PagoPlanes){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<any>(this.url + "pagos" + "/guardar",  serv ,{headers : httpHeaders});
  }

  editarPlanes(token : string | null, serv : PlanesFuturos){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<any>(this.url + "planes" + "/editar",  serv ,{headers : httpHeaders});
  }

  eliminarPlanes(token : string | null, serv : PlanesFuturos){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<any>(this.url + "planes" + "/eliminar",  serv ,{headers : httpHeaders});
  }

  eliminarRecs(token : string | null, serv : Recordatorios){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<any>(this.url + "recordatorio" + "/eliminar",  serv ,{headers : httpHeaders});
  }

  isAdmin(token : string | null, serv : string){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<boolean>(this.url + "clientes" + "/admin  ", serv, {headers : httpHeaders});
  }
  
  listarPlanes(token : string | null){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.get<PlanesFuturos[]>(this.url + "planes" + "/listar  ", {headers : httpHeaders});
  }

  listarClientes(token : string | null){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.get<Clientes[]>(this.url + "clientes" + "/listar  ", {headers : httpHeaders});
  }

  recordatoriosPorCliente(token : string | null, email : string){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.post<Recordatorios[]>(this.url + "recordatorio" + "/buscar/cliente",email, {headers : httpHeaders});
  }
}
