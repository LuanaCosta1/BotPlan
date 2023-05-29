import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProjectModel } from '../../models/project.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  baseUrl = "http://localhost:3000/projects"

  constructor(private http: HttpClient) { }

  public getAll(): Observable<ProjectModel[]> {
    return this.http.get<ProjectModel[]>(this.baseUrl);
  }

  public getProjectById(id: number): Observable<ProjectModel> {
    return this.http.get<ProjectModel>(`${this.baseUrl}/${id}`);
  }

  public addProject(request: ProjectModel): Observable<ProjectModel> {
    return this.http.post<ProjectModel>(this.baseUrl, request);
  }

  public updateProject(request: ProjectModel, id: number): Observable<ProjectModel> {
    return this.http.put<ProjectModel>(`${this.baseUrl}/${id}`, request);
  }

  public deleteProject(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
