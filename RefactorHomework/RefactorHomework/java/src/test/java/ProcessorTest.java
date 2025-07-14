import model.Branch;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

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
}