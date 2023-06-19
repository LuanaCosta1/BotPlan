import { Component, Input, OnInit } from '@angular/core';
import { EmployeeModel } from 'src/app/core/models/employee.model';
import { TaskModel } from 'src/app/core/models/task.model';
import { EmployeeService } from 'src/app/core/services/employee/employee.service';
import { ProjectService } from 'src/app/core/services/projects/project.service';
import { TaskService } from 'src/app/core/services/task/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss'],
})
export class TaskListComponent implements OnInit {
  @Input() displayListView = true;
  @Input() taskList: TaskModel[] = [];
  taskOptions = [
    {
      title: 'update',
    },
  ];
  taskSelected: TaskModel = new TaskModel();

  constructor(
    private projectsService: ProjectService,
    private taskService: TaskService
  ) {}

  ngOnInit(): void {
    const user = JSON.parse(sessionStorage.getItem('user') as string);
    this.checkIfHasAdminRights(user);
  }

  checkIfHasAdminRights(user: EmployeeModel) {
    return user.admin;
  }

  getTaskSelected(task: TaskModel) {
    this.projectsService.getProjectById(1).subscribe((project) => {
      project.sprints.forEach((sprint) => {
        this.taskSelected = sprint.stories.filter((story) => {
          return story.idStory == task.idStory;
        })[0];
        console.log(this.taskSelected);
      })
    });
  }
}
