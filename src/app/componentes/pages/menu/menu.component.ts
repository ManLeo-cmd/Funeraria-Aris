import { Component, Inject, LOCALE_ID, OnInit } from '@angular/core';
import { PlanesFuturos } from '../../../entidad/planesFuturuos/planes-futuros';
import { TokenService } from '../../../servidor/token/token.service';
import { Clientes } from '../../../entidad/clientes/clientes';
import { ServicioInmediatoService } from '../../../servidor/servicioInmediato/servicio-inmediato.service';
import { Recordatorios } from '../../../entidad/recordatorios/recordatorios';
import { PagoPlanes } from '../../../entidad/pagoPlanes/pago-planes';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-menu',
  imports: [],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent implements OnInit{

  items : string[] = new Array;
  usr !: Clientes;
  list !: Recordatorios[];
  pagos : PagoPlanes[] = new Array;
  dates : string[] = new Array;
  ataud = ['ataud de madera mdf',
    'ataud de madera basico',
    'ataud de madera de lujo'
  ];
  traslado = ['traslado local a 40km','traslado local a 80km', 'traslado local a 120km']
  extras = [null, 
    'sala de velación, gestoria y tramitación','sala de velación, gestoria y tramitación'
  ]

  panteon = [null, null, 'Panteón']

  precio = ['90,000', '110,000', '120,000']
  constructor(private token : TokenService, private service : ServicioInmediatoService, @Inject(LOCALE_ID) public locale : string){}

  ngOnInit(): void {
    var toks = this.token.getToken();
    this.buscar(toks);
    for (let index = 0; index < 3; index++) {
      this.items[index] = "";
      
    }
  }

  buscar(token : string | null){
    this.token.obtainUser(token).subscribe(data => {
      this.usr = data.cliente;
      this.service.recordatoriosPorCliente(token, this.usr.email).subscribe(data => {
        this.list = data;
        for (let index = 0; index < data.length; index++) {
          this.service.buscarUltimoPago(token, data[index].planes.id_plan).subscribe(dats => {
            this.pagos.push(dats);
            this.dates[index] =  formatDate(dats.fechaPago, 'dd-MMMM-yyyy' ,this.locale);
          });
        }
      });
    });
  }

  eliminar(i : Recordatorios){
    var toks = this.token.getToken();
    this.service.eliminarRecs(toks, i).subscribe(() => {
      location.reload();
    })
  }



}
