import model.Branch;
import model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class Processor {
    /**
     * Will return the most productive that the employee has ever been
     *
     * @param employeeName the name of the employee to analyse
     * @param annualData   all historical data we have across all branches
     * @return the most productivity or null.
     */
    public final Integer getBestProductivityForEmployee(String employeeName, Map<String, Map<String, Branch>> annualData) {
        Integer bestProductivity = null;
        if (annualData != null) {
            for (String year : annualData.keySet()) {
                Map<String, Branch> branches = annualData.get(year);
                if (branches != null) {
                    for (Branch branch : branches.values()) {
                        if (branch != null && branch.getEmployees() != null) {
                            for (Employee employee : branch.getEmployees()) {
                                if (employee != null && employee.getName() != null && employee.getName().equals(employeeName)) {
                                    if (bestProductivity == null || (employee.getProductivity() != null && employee.getProductivity() > bestProductivity)) {
                                        bestProductivity = employee.getProductivity();
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
}
