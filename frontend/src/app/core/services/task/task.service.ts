import { Injectable } from '@angular/core';
import { TaskModel } from '../../models/task.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  baseUrl = "http://localhost:8080"

  constructor(private http: HttpClient) { }

  public getAllTasks(): Observable<TaskModel[]> {
    return this.http.get<TaskModel[]>(`${this.baseUrl}/`);
  }

  public getTaskById(idProject: number, idSprint: number, idStory: number): Observable<TaskModel> {
    return this.http.get<TaskModel>(`${this.baseUrl}/${idProject}/sprints/${idSprint}/tasks/${idStory}`);
  }

  public addTask(idProject: number, idSprint: number, request: TaskModel): Observable<TaskModel> {
    return this.http.post<TaskModel>(`${this.baseUrl}/${idProject}/sprints/${idSprint}/tasks`, request);
  }

  public updateTask(idProject: number, idSprint: number, request: TaskModel, idStory: number): Observable<TaskModel> {
    return this.http.put<TaskModel>(`${this.baseUrl}/${idProject}/sprints/${idSprint}/tasks/${idStory}`, request);
  }

  public deleteTask(idProject: number, idSprint: number, idStory: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${idProject}/sprints/${idSprint}/tasks/${idStory}`);
  }
}
