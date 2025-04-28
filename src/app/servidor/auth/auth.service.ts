import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginReq } from '../../entidad/loginReq/login-req';
import { RegisterReq } from '../../entidad/registerReq/register-req';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http : HttpClient) {}

  url = "http://localhost:8080/";

  login(req : LoginReq){
    return this.http.post<any>(this.url + "auth/login", req);
  }

  register(req : RegisterReq){
    return this.http.post<any>(this.url + "auth/register", req);
  }

  logout(token : string | null){
    const httpHeaders : HttpHeaders = new HttpHeaders({
          Authorization : 'Bearer ' + token
        });
    return this.http.get<any>(this.url + "auth" + "/logout", {headers : httpHeaders});
  }


}
