import { Component } from '@angular/core';
import { LoginReq } from '../../../entidad/loginReq/login-req';
import { AuthService } from '../../../servidor/auth/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { TokenService } from '../../../servidor/token/token.service';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
  reqs : LoginReq = new LoginReq();
  constructor(private auth : AuthService, private router : Router, private token : TokenService){}


  login(req: LoginReq){
    console.log(req);
    this.auth.login(req).subscribe(data => {
      this.token.setToken(data.access_token);
      this.router.navigate(['auth']);
    });
  }

}
