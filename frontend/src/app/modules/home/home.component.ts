import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaskModel } from 'src/app/core/models/task.model';
import { ProjectService } from 'src/app/core/services/projects/project.service';
import { taskPriority } from 'src/app/utils/utils';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  modalToogle = false;
  taskList: TaskModel[] = [];
  displayListView = true;
  loadingList = false;
  backlog: TaskModel[] = [];
  showBacklog = false;
  actualSprintId = 1;

  constructor(private projectService: ProjectService, private router: Router) {}

  openModal(event: any) {
    this.modalToogle = true;
  }

  ngOnInit(): void {
    this.getAllTasks();
  }

  changeDisplay(view: string) {
    this.displayListView = (view == "listView") ? true : false;
  }

  getAllTasks() {
    this.loadingList = true;
    this.projectService.getAll()
    .subscribe({
      next: (projectList) => {
        projectList.forEach((project) => {
          this.taskList = project.sprints[this.actualSprintId-1].stories;
          this.backlog = project.backlog;
        })
      },
    complete: () => {
        setTimeout(() => {this.loadingList = false;}, 1000)
      }
    });
  }
}
