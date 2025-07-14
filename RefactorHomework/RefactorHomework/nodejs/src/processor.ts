import { BranchData } from "./model/BranchData";

export function getBestProductivityForEmployee(
  employeeName: string,
  annualData: BranchData | null
): number | null {
  let bestProductivity: number | null = null;
  if (annualData) {
    for (let yearStr in annualData) {
      let year = annualData[yearStr];
      if (year) {
        for (let branchName in year) {
          let branch = year[branchName];
          if (branch && branch.employees) {
            for (let employee of branch.employees) {
              if (employee && employee.name && employee.name == employeeName) {
                if (employee.productivity) {
                  if (!bestProductivity) {
                    bestProductivity = employee.productivity;
                  } else if (employee.productivity > bestProductivity) {
                    bestProductivity = employee.productivity;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  return bestProductivity;
}
