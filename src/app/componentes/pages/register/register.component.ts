import { Component } from '@angular/core';
import { AuthService } from '../../../servidor/auth/auth.service';
import { RegisterReq } from '../../../entidad/registerReq/register-req';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  reqs : RegisterReq = new RegisterReq();

  constructor(private auth : AuthService, private router : Router){}


  register(req: RegisterReq){
    console.log(req);
    this.auth.register(req).subscribe(() => {
      this.router.navigate(["login"]);
    });
  }


}
