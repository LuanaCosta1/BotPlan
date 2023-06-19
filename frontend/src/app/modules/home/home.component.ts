import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeModel } from 'src/app/core/models/employee.model';
import { TaskModel } from 'src/app/core/models/task.model';
import { EmployeeService } from 'src/app/core/services/employee/employee.service';
import { ProjectService } from 'src/app/core/services/projects/project.service';
import { storyPriorities, storyStates, storyTypes } from 'src/app/utils/utils';

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
  storyStates: StateModel[] = [];
  storyPriorities: StateModel[] = [];
  storyTypes: StateModel[] = [];
  employeeList: EmployeeModel[] = [];
  newTask: TaskModel = new TaskModel();

  constructor(
    private projectService: ProjectService,
    private router: Router,
    private employeeService: EmployeeService,
    private fb: FormBuilder
  ) {
    this.storyStates = storyStates;
    this.storyPriorities = storyPriorities;
    this.storyTypes = storyTypes;
  }

  createTaskForm = this.fb.group({
    title: ['', [Validators.required]],
    description: ['', [Validators.required]],
    notes: [''],
    points: [''],
    state: ['', [Validators.required]],
    priority: ['', [Validators.required]],
    type: ['', [Validators.required]],
    employeeSelected: ['', [Validators.required]],
  });

  openModal(event: any) {
    this.modalToogle = true;
  }

  ngOnInit(): void {
    this.getAllTasks();
    this.getAllEmployees();
  }

  changeDisplay(view: string) {
    this.displayListView = view == 'listView' ? true : false;
  }

  getAllTasks() {
    this.loadingList = true;
    this.projectService.getAll().subscribe({
      next: (projectList) => {
        projectList.forEach((project) => {
          this.taskList = project.sprints[this.actualSprintId - 1].stories;
          this.backlog = project.backlog;
        });
      },
      complete: () => {
        setTimeout(() => {
          this.loadingList = false;
        }, 1000);
      },
    });
  }

  getAllEmployees() {
    this.employeeService.getAllEmployees().subscribe((employeeList) => {
      this.employeeList = employeeList;
    });
  }

  createNewTask() {


    console.log(this.createTaskForm);

    this.newTask = {
      "idStory": 1,
      "title": this.createTaskForm.get('title')?.value as string,
      "description": this.createTaskForm.get('description')?.value as string,
      "notes": this.createTaskForm.get('notes')?.value as string,
      "points": Number(this.createTaskForm.get('points')?.value),
      "state": this.createTaskForm.get('state')?.value as string,
      "priority": this.createTaskForm.get('priority')?.value as string,
      "type": this.createTaskForm.get('type')?.value as string,
      "testerAssigned": undefined,
      "creator": undefined,
      "creationDate": new Date(),
      "conclusionDate": undefined,
      "idEmployee": 1,
      "backupIdEmployee": 1,
    }
  }

  getEmployeeSelected(id: string) {
    console.log(id);
    this.employeeService.getEmployeeById(id).subscribe((employee) => {
      console.log(employee);
    })
  }
}


export interface StateModel {
  value: number;
  state: string;
}
