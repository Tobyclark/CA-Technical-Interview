import { Department, Status } from "./enums";

export class BranchData {
  [year: string]: Record<string, Branch | null> | null;
}

export interface Branch {
  branchName: string | null;
  specialty: Department | null;
  employees: Array<Employee | null> | null;
}

export interface Employee {
  name: string | null;
  status: Status | null;
  department: Department | null;
  productivity: number | null;
}
