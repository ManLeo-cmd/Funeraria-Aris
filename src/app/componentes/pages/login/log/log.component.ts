import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { Nav2Component } from "../../../nav2/nav2.component";
import { TokenService } from '../../../../servidor/token/token.service';

@Component({
  selector: 'app-log',
  imports: [RouterOutlet,  Nav2Component],
  templateUrl: './log.component.html',
  styleUrl: './log.component.css'
})
export class LogComponent implements OnInit{

  constructor(private router : Router, private tokenService : TokenService){}

  token !: string | null;

  ngOnInit(): void {
    var toks = this.tokenService.getToken();
    if(toks != null){
      this.tokenService.validToken(toks).subscribe(() => {
        this.token = toks;
      }, error => {
        this.router.navigate(['']);
      });
    }
  }

}
