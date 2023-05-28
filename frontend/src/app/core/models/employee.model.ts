import { TaskModel } from "./task.model";

export class EmployeeModel {
  "idEmployee": number;
  "name": string;
  "picture": string;
  "stack": string;
  "technologies": string[];
  "seniority": string;
  "admin": boolean;
  "type": string;
  "isWorking": boolean;
  "reasonWhyNotWorking": string | null;
  "taskAssigned": TaskModel[];
}
