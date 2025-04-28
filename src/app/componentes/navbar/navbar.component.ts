import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-navbar',
  imports: [NgClass],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  show = false;

  collapsed = true;


  nof = false;

  num : number = 0;


  constructor(
    private router : Router
  ){}
  
  ngOnInit(): void {
  }
  
  toggleCollapsed(): void {
    this.collapsed = !this.collapsed;
  }

  buscar(token : string | null){
  }

  mensajes(){
    
  }

}
