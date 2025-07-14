import { plainToInstance } from "class-transformer";
import { readFileSync } from "fs";
import { BranchData } from "./model/BranchData";

export function parseBranchesByYear(file: string): BranchData {
  let dataString = readFileSync(file).toString();
  return parseRawBranchesByYear(dataString);
}

export function parseRawBranchesByYear(json: string): BranchData {
  return plainToInstance(BranchData, JSON.parse(json));
}
