import model.Branch;
import model.Employee;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProcessorTest {
    private final Parser parser = new Parser();
    private final Processor processor = new Processor();

    @Test
    public void getBestProductivityForEmployee_basicTest() {
        Map<String, Map<String, Branch>> employeeData = parser.parseBranchesByYear("sample.json");

        Integer result;

        result = processor.getBestProductivityForEmployee("Joward Maximilian", employeeData);
        assertEquals(Integer.valueOf(83), result);

        result = processor.getBestProductivityForEmployee("Big Tom", employeeData);
        assertEquals(Integer.valueOf(98), result);

        result = processor.getBestProductivityForEmployee("7 Toe Bill", employeeData);
        assertEquals(Integer.valueOf(7), result);

    }

    @Test
    public void getBestProductivityForEmployee_nullAnnualData() {
        Integer result = processor.getBestProductivityForEmployee("abcdef", null);
        assertNull(result);
    }

    @Test
    public void getBestProductivityForEmployee_nullEmployeeName() {
        Map<String, Map<String, Branch>> employeeData = parser.parseBranchesByYear("sample.json");

        Integer result = processor.getBestProductivityForEmployee(null, employeeData);
        assertNull(result);
    }

    @Test
    public void getBestProductivityForEmployee_missingEmployeeInData() {
        Map<String, Map<String, Branch>> employeeData = parser.parseBranchesByYear("sample.json");

        Integer result = processor.getBestProductivityForEmployee("Nonexistent Name", employeeData);
        assertNull(result);
    }

    @Test
    public void getBestProductivityForEmployee_nullProductivityFields() {
        Map<String, Map<String, Branch>> employeeData = parser.parseBranchesByYear("sample.json");

        Integer result = processor.getBestProductivityForEmployee("Pamila Richardson", employeeData);
        assertEquals(Integer.valueOf(93), result);

        result = processor.getBestProductivityForEmployee("Jane Doe", employeeData);
        assertEquals(Integer.valueOf(86), result);
    }
}