import { Injectable } from '@angular/core';
import { TaskModel } from '../../models/task.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  baseUrl = "http://localhost:3000/tasks"

  constructor(private http: HttpClient) { }

  public getAllTasks(): Observable<TaskModel[]> {
    return this.http.get<TaskModel[]>(this.baseUrl);
  }

  public getTaskById(id: number): Observable<TaskModel> {
    return this.http.get<TaskModel>(`${this.baseUrl}/${id}`);
  }

  public addTask(request: TaskModel): Observable<TaskModel> {
    return this.http.post<TaskModel>(this.baseUrl, request);
  }

  public updateTask(request: TaskModel, id: number): Observable<TaskModel> {
    return this.http.put<TaskModel>(`${this.baseUrl}/${id}`, request);
  }

  public deleteTask(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
