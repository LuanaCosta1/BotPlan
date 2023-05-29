import { Component, Input } from '@angular/core';
import { TaskModel } from 'src/app/core/models/task.model';

@Component({
  selector: 'app-backlog-list',
  templateUrl: './backlog-list.component.html',
  styleUrls: ['./backlog-list.component.scss']
})
export class BacklogListComponent {
  @Input() displayListView = true;
  @Input() backlogList: TaskModel[] = [];
}
