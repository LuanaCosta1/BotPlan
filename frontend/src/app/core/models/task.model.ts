export class TaskModel {
  "idStory": number;
  "title": string;
  "description": string;
  "notes": string;
  "points": number;
  "state": string;
  "priority": string;
  "type": string;
  "testerAssigned"?: string;
  "creator"?: string;
  "creationDate": Date;
  "conclusionDate"?: Date;
  "idEmployee": number;
  "backupIdEmployee": number;
}
