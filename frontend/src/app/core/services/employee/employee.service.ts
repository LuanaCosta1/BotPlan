import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeModel } from '../../models/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  baseUrl = "http://localhost:3000/employees"

  constructor(private http: HttpClient) { }

  public getAllEmployees(): Observable<EmployeeModel[]> {
    return this.http.get<EmployeeModel[]>(this.baseUrl);
  }

  public getEmployeeById(id: string): Observable<EmployeeModel> {
    return this.http.get<EmployeeModel>(`${this.baseUrl}/${id}`);
  }

  public addEmployee(request: EmployeeModel): Observable<EmployeeModel> {
    return this.http.post<EmployeeModel>(this.baseUrl, request);
  }

  public updateEmployee(request: EmployeeModel, id: number): Observable<EmployeeModel> {
    return this.http.put<EmployeeModel>(`${this.baseUrl}/${id}`, request);
  }

  public deleteEmployee(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  public getEmployeePicture(username: string): string {
    return "https://robohash.org/" + username;
  }
}
