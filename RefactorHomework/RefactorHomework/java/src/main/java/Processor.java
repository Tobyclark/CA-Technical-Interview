import model.Branch;
import model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Processor {
    /**
     * Will return the most productive that the employee has ever been
     *
     * @param employeeName the name of the employee to analyse
     * @param annualData   all historical data we have across all branches
     * @return the most productivity or null.
     */
    public final Integer getBestProductivityForEmployee(String employeeName, Map<String, Map<String, Branch>> annualData) {
        return Optional.ofNullable(annualData)
            .map(Map::values)
            .stream()
            .flatMap(Collection::stream)
        // get a stream of branches (for each year)
        .flatMap(branchMap -> Optional.ofNullable(branchMap)
            .map(Map::values)
            .stream()
            .flatMap(Collection::stream))

        // convert each branch in the stream to employees
        .flatMap(branch -> Optional.ofNullable(branch)
            .map(Branch::getEmployees)
            .stream()
            .flatMap(Collection::stream))

        // filter the stream to only include employees with the given name
        .flatMap(employee -> Optional.ofNullable(employee)
            .filter(e -> Optional.ofNullable(e.getName())
                .map(employeeName::equals)
                .orElse(false))
            .map(Stream::of)
            .orElseGet(Stream::empty))

        // get max productivity from the remaining employees
        .flatMap(emp -> Optional.ofNullable(emp.getProductivity()).stream())
        .max(Integer::compareTo)
        .orElse(null);
}
    }
