import { Component, OnInit } from '@angular/core';
import { PlanesFuturos } from '../../../../entidad/planesFuturuos/planes-futuros';
import { TokenService } from '../../../../servidor/token/token.service';
import { ServicioInmediatoService } from '../../../../servidor/servicioInmediato/servicio-inmediato.service';
import { Clientes } from '../../../../entidad/clientes/clientes';

@Component({
  selector: 'app-recordatorios',
  imports: [],
  templateUrl: './recordatorios.component.html',
  styleUrl: './recordatorios.component.css'
})
export class RecordatoriosComponent implements OnInit{

  planes !: PlanesFuturos[];
  clientes !: Clientes[];
  id !: number;
  ik !: number;

  constructor(private token : TokenService, private service : ServicioInmediatoService){}

  ngOnInit(): void {
    var toks = this.token.getToken();
    this.service.listarPlanes(toks).subscribe(data => {
      this.planes = data;
    })

    
  }

  eliminar(planes : PlanesFuturos){
    var toks = this.token.getToken();
    this.service.eliminarPlanes(toks, planes).subscribe(() => {
      location.reload();
    });
  }


 

}
