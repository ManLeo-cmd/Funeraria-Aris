import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-info',
  imports: [],
  templateUrl: './info.component.html',
  styleUrl: './info.component.css'
})
export class InfoComponent implements OnInit{
  
  items : string[] = new Array;
  ataud = ['ataud de madera mdf',
    'ataud de madera basico',
    'ataud de madera de lujo'
  ];
  traslado = ['traslado local a 40km','traslado local a 80km', 'traslado local a 120km']
  extras = [null, 
    'sala de velación, gestoria y tramitación','sala de velación, gestoria y tramitación'
  ]
  extras2 = [null, 'certificado medico, gestoria y tramitacion y sala de velación', 'certificado medico, gestoria y tramitacion y sala de velación'];
  panteon = [null, null, 'Panteón']

  otros = [null, null, 'servicio de aguas, sombrillas, carpas a la hora de la sepultura'];

  precio = ['90,000', '110,000', '120,000']
  precio2 = ['25,000', '27,000', '29,000']
  ngOnInit(): void {
    for (let index = 0; index < 3; index++) {
      this.items[index] = "";
      
    }
  }

}
