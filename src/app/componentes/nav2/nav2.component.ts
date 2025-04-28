import { NgClass, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../servidor/auth/auth.service';
import { TokenService } from '../../servidor/token/token.service';
import { ServicioInmediatoService } from '../../servidor/servicioInmediato/servicio-inmediato.service';
import { Clientes } from '../../entidad/clientes/clientes';

@Component({
  selector: 'app-nav2',
  imports: [NgClass],
  templateUrl: './nav2.component.html',
  styleUrl: './nav2.component.css'
})
export class Nav2Component {

  collapsed2 = true;
  admin = false;
  usr !: Clientes;

  constructor(
    private router : Router,
    private auth : AuthService,
    private tokenService : TokenService,
    private service : ServicioInmediatoService
  ){}
  
  ngOnInit(): void {
    var toks = this.tokenService.getToken();
    this.buscar(toks);
    console.log(this.admin)
  }

  buscar(token : string | null){
    this.tokenService.obtainUser(token).subscribe(data => {
      this.usr = data.cliente;
      this.service.isAdmin(token, data.cliente.email).subscribe(data => {
        console.log(data);
        this.admin = data;
      })
    });
  }
  
  toggleCollapsed2(): void {
    this.collapsed2 = !this.collapsed2;
  }

  logout(){
    var toks = this.tokenService.getToken();
    this.auth.logout(toks).subscribe(() => {
      this.router.navigate(['']);
    });
  }


}
