import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { AuthenticationUser } from '../../models/authentication-user.model';
import { ResponseModel } from '../../models/response-model.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  baseUrl = "http://localhost:3000/authenticationUser"

  constructor(private http: HttpClient) { }

  public getAllUsers(): Observable<AuthenticationUser[]> {
    return this.http.get<AuthenticationUser[]>(this.baseUrl);
  }

  public getUserById(id: number): Observable<AuthenticationUser> {
    return this.http.get<AuthenticationUser>(`${this.baseUrl}/${id}`);
  }

  public addUser(request: AuthenticationUser): Observable<AuthenticationUser> {
    return this.http.post<AuthenticationUser>(this.baseUrl, request);
  }

  public updateUser(request: AuthenticationUser, id: number): Observable<AuthenticationUser> {
    return this.http.put<AuthenticationUser>(`${this.baseUrl}/${id}`, request);
  }

  public deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
