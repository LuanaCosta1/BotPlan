import { ClientModel } from "./client.model";
import { SprintModel } from "./sprint.model";
import { TaskModel } from "./task.model";

export class ProjectModel {
  "id": number;
  "projectName": string;
  "projectDescription": string;
  "startDate": string;
  "endDate": string | null;
  "projectManager": string;
  "employeesListId": number[];
  "technologiesUsed": string[];
  "status": string;
  "client": ClientModel;
  "backlog": TaskModel[];
  "sprints": SprintModel[];
}
