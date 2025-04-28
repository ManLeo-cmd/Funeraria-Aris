import { Component, Inject, LOCALE_ID, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ServicioInmediato } from '../../../../entidad/servicioInmediato/servicio-inmediato';
import { Router } from '@angular/router';
import { TokenService } from '../../../../servidor/token/token.service';
import { Clientes } from '../../../../entidad/clientes/clientes';
import { ServicioInmediatoService } from '../../../../servidor/servicioInmediato/servicio-inmediato.service';
import { PersonalizacionServicios } from '../../../../entidad/PersonalizacionServicios/personalizacion-servicios';
import { Facturacion } from '../../../../entidad/Facturacion/facturacion';
import e from 'express';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-inmediata',
  imports: [FormsModule],
  templateUrl: './inmediata.component.html',
  styleUrl: './inmediata.component.css'
})
export class InmediataComponent implements OnInit{

  constructor(private router : Router, private token : TokenService, private Inmediato : ServicioInmediatoService,@Inject(LOCALE_ID) public locale : string){}

  ngOnInit(): void {
    var toks = this.token.getToken();
    this.buscar(toks);
  }

  servInmed : ServicioInmediato = new ServicioInmediato();
  person : PersonalizacionServicios = new PersonalizacionServicios();
  fact : Facturacion  = new Facturacion();
  usr !: Clientes;


  buscar(token : string | null){
    this.token.obtainUser(token).subscribe(data => {
      this.usr = data.cliente;
    });
  }

  enviar(){
    var toks = this.token.getToken();
    this.servInmed.cliente = this.usr;
    this.person.cliente = this.usr;
    this.fact.cliente = this.usr;
    this.servInmed.factura = this.fact;
    this.Inmediato.guardar(toks, this.servInmed).subscribe(() => {
      this.Inmediato.guardarPersonalizacion(toks, this.person).subscribe(() => {
        this.router.navigate(['auth'])
      })
    });
  }

  change(event : string){
    this.fact.fechaEmision = new Date();
    switch(event){
      case 'S1':
        this.fact.detalles = "DETALLE 1";
        this.fact.total = 25000;
        break;
      case 'S2':
        this.fact.detalles = "DETALLE 2";
        this.fact.total = 27000;
        break;
      case 'S3':
        this.fact.detalles = "DETALLE 3";
        this.fact.total = 29000;
        break;
      case 'S4':
        this.fact.detalles = "DETALLE 4";
        this.fact.total = 32000;
        break;
      case 'S5':
        this.fact.detalles = "DETALLE 5";
        this.fact.total = 35000;
        break;
      default:
        alert("ESTA OPCIÓN ES INCORRECTA");
        break;

    
    }
    
  }


}
