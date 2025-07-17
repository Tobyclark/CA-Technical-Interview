import model.Branch;
import model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Processor {
    /**
     * Will return the years of data as a stream of branches
     * @param data the annual data
     * @return a stream of branches
     */
    private Stream<Map<String, Branch>> getYears(Map<String, Map<String, Branch>> data) {
    return data == null ? Stream.empty() : data.values().stream();
    }

    /**
     * Will return the branches as a stream
     * @param branchMap the map of branches
     * @return a stream of branches
     */
    private Stream<Branch> getBranches(Map<String, Branch> branchMap) {
        return branchMap == null ? Stream.empty() : branchMap.values().stream();
    }

    /**
     * Will return the employees as a stream
     * @param branch the branch
     * @return a stream of employees
     */
    private Stream<Employee> getEmployees(Branch branch) {
        return branch == null || branch.getEmployees() == null ? Stream.empty() : branch.getEmployees().stream();
    }

    /**
     * Will return true if the employee matches the name
     * @param employee the employee
     * @param employeeName the name of the employee
     * @return true if the employee matches the name
     */
    private boolean isMatchingEmployee(Employee employee, String employeeName) {
        return employee.getName() == null ? employeeName == null : employee.getName().equals(employeeName);
    }

    /**
     * Will return the most productive that the employee has ever been
     *
     * @param employeeName the name of the employee to analyse
     * @param annualData   all historical data we have across all branches
     * @return the most productivity or null.
     */
    public final Integer getBestProductivityForEmployee(String employeeName, Map<String, Map<String, Branch>> annualData) {
    return getYears(annualData)
            .flatMap(this::getBranches)
            .flatMap(this::getEmployees)
            .filter(employee -> isMatchingEmployee(employee, employeeName))
            .map(Employee::getProductivity)
            .max(Comparator.naturalOrder())
            .orElse(null);
    }
}
