import { Component, Input } from '@angular/core';
import { TaskModel } from 'src/app/core/models/task.model';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent{
  @Input() displayListView = true;
  @Input() taskList: TaskModel[] = [];
}
