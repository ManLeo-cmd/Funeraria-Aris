import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Token } from '../../entidad/token/token';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/";


  private TOKEN_KEY = 'token';

  validToken(token : string | null){
   return this.http.post<any>(this.url + "auth" + "/user", token);
  }

  obtainUser(token : string | null){
    return this.http.post<Token>(this.url + "auth" + "/user", token);
   }

  setToken(token : string){
    sessionStorage.setItem(this.TOKEN_KEY, token);
  }

  getToken(){
    return sessionStorage.getItem(this.TOKEN_KEY);
  }

  deleteCookie(){
    sessionStorage.removeItem(this.TOKEN_KEY);
  }


}
