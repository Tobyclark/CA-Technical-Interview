import assert from "assert";
import { parseBranchesByYear } from "./parser";
import { getBestProductivityForEmployee } from "./processor";

const employeeData = parseBranchesByYear("./src/assets/sample.json");

let result: number | null = 0;
result = getBestProductivityForEmployee("Joward Maximilian", employeeData);
assert.equal(result, 83);

result = getBestProductivityForEmployee("Big Tom", employeeData);
assert.equal(result, 98);

result = getBestProductivityForEmployee("7 Toe Bill", employeeData);
assert.equal(result, 7);

console.log("Done: All tests passed");
