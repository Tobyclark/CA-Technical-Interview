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
        assertNull(processor.getBestProductivityForEmployee("Jimbob", null));
    }

    @Test
    public void getBestProductivityForEmployee_nullEmployee() {
        Map<String, Map<String, Branch>> data = new HashMap<>();
        assertNull(processor.getBestProductivityForEmployee(null, data));
    }

    @Test
    public void getBestProductivityForEmployee_nullBranches() {
        Map<String, Map<String, Branch>> data = new HashMap<>();
        data.put("2020", null);
        assertNull(processor.getBestProductivityForEmployee("Jimbob", data));
    }
}