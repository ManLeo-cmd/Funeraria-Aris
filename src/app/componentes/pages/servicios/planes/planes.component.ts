import { Component, Inject, LOCALE_ID, OnInit } from '@angular/core';
import { InmediataComponent } from '../inmediata/inmediata.component';
import { PlanesFuturos } from '../../../../entidad/planesFuturuos/planes-futuros';
import { ServicioInmediatoService } from '../../../../servidor/servicioInmediato/servicio-inmediato.service';
import { TokenService } from '../../../../servidor/token/token.service';
import { Clientes } from '../../../../entidad/clientes/clientes';
import { PagoPlanes } from '../../../../entidad/pagoPlanes/pago-planes';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-planes',
  imports: [],
  templateUrl: './planes.component.html',
  styleUrl: './planes.component.css'
})
export class PlanesComponent implements OnInit{

  show : boolean[] = new Array;
  planes !: PlanesFuturos[];
  usr : Clientes = new Clientes();
  pagos : PagoPlanes[] = new Array;
  pags : PagoPlanes = new PagoPlanes();
  date : string[] = new Array;

  constructor(private service : ServicioInmediatoService, private token : TokenService, @Inject(LOCALE_ID) public locale : string){}

  ngOnInit(): void {
    var toks = this.token.getToken();
    this.buscar(toks);
    
  }

  buscar(token : string | null){
    this.token.obtainUser(token).subscribe(data => {
      this.usr = data.cliente;
      this.service.buscarPlanCliente(token, this.usr.id).subscribe(data => {
        this.planes = data;
        for (let index = 0; index < data.length; index++) {
          this.show[index] = false;
          this.date[index] = "";
        }
      });
    });
  }

  eliminar(planes : PlanesFuturos){
    var toks = this.token.getToken();
    this.service.eliminarPlanes(toks, planes).subscribe(() => {
      location.reload();
    });
  }

  guardar(item : PlanesFuturos, index : number){
    var toks = this.token.getToken();
    this.show[index] = !this.show[index];
    this.pagos = new Array;
    this.service.buscarPagosPlan(toks, item.id_plan).subscribe(data => {
      data.forEach(dats => {
        if(!dats.pagado){
          this.pagos.push(dats);
        }
      })
      this.service.buscarUltimoPago(toks, item.id_plan).subscribe(dats => {
        this.pags = dats
        this.date[index] = formatDate(dats.fechaPago, 'dd-MMMM-yyyy' ,this.locale);
      });
    });
  }

  pagado(item : PlanesFuturos){
    var toks = this.token.getToken();
    if(item.saldoRestante == 0){
      return;
    }
    item.saldoRestante =  item.saldoRestante - (item.costo/item.mensualidades);
    this.pags.pagado = true;
    item.mesesPagados++;
    this.service.guardarPagos(toks, this.pags).subscribe(() => {
      this.service.editarPlanes(toks, item).subscribe(() => {
        location.reload();
      });
    });
  }
}
