import { AuthenticationUser } from "./authentication-user.model";
import { TaskModel } from "./task.model";

export class EmployeeModel {
  "id": string;
  "name": string;
  "picture"?: string;
  "stack"?: string;
  "technologies"?: string[];
  "seniority"?: string;
  "admin": boolean;
  "type"?: string;
  "isWorking": boolean;
  "reasonWhyNotWorking"?: string | null;
  "taskAssigned"?: TaskModel[];
  "authentication": AuthenticationUser;
}
