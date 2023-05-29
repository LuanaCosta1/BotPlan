import { TaskModel } from "./task.model";

export class SprintModel {
  "sprintId": number;
  "startDate": string;
  "endDate": string;
  "goal": string;
  "stories": TaskModel[];
}
