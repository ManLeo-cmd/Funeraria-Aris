import { Component, OnInit } from '@angular/core';
import { TokenService } from '../../../../servidor/token/token.service';
import { ServicioInmediatoService } from '../../../../servidor/servicioInmediato/servicio-inmediato.service';
import { Clientes } from '../../../../entidad/clientes/clientes';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { PlanesFuturos } from '../../../../entidad/planesFuturuos/planes-futuros';
import { Facturacion } from '../../../../entidad/Facturacion/facturacion';
import { PagoPlanes } from '../../../../entidad/pagoPlanes/pago-planes';

@Component({
  selector: 'app-prevision',
  imports: [FormsModule],
  templateUrl: './prevision.component.html',
  styleUrl: './prevision.component.css'
})
export class PrevisionComponent implements OnInit{

  usr : Clientes = new Clientes();
  nombre !: string;
  fact : Facturacion  = new Facturacion();
  planes : PlanesFuturos = new PlanesFuturos();
  pagos : PagoPlanes = new PagoPlanes();
  tot !: number;

  constructor(private router : Router, private token : TokenService, private Inmediato : ServicioInmediatoService){}

  ngOnInit(): void {
    var toks = this.token.getToken();
    this.buscar(toks);
  }

  buscar(token : string | null){
    this.token.obtainUser(token).subscribe(data => {
      this.usr = data.cliente;
    });
  }

  change(event : string){
    this.fact.fechaEmision = new Date();
    this.planes.nombre = this.nombre;
    switch(event){
      case 'S1':
        this.planes.nombre = "PAQUETE 1";
        this.planes.costo = 90000;
        this.fact.detalles = "DETALLE 1";
        this.fact.total = 90000;
        break;
      case 'S2':
        this.planes.nombre = "PAQUETE 2";
        this.planes.costo = 110000;
        this.fact.detalles = "DETALLE 2";
        this.fact.total = 110000;
        
        break;
      case 'S3':
        this.planes.nombre = "PAQUETE 3";
        this.planes.costo = 120000;
        this.fact.detalles = "DETALLE 3";
        this.fact.total = 120000;
        break;
      case 'S4':
        this.planes.nombre = "PAQUETE 4";
        this.planes.costo = 130000;
        this.fact.detalles = "DETALLE 4";
        this.fact.total = 130000;
        break;
      case 'S5':
        this.planes.nombre = "PAQUETE 5";
        this.planes.costo = 150000;
        this.fact.detalles = "DETALLE 5";
        this.fact.total = 150000;
        break;
      default:
        alert("ESTA OPCIÓN ES INCORRECTA");
        break;
    }
    
  }

  change2(event : string){
    this.tot = this.planes.costo / this.planes.mensualidades;
  }

  enviar(){
    var toks = this.token.getToken();
    this.planes.cliente = this.usr;
    this.planes.saldoRestante = this.planes.costo;
    this.Inmediato.guardarPlanes(toks, this.planes).subscribe(() => {
      location.reload();
    });
  }

}
