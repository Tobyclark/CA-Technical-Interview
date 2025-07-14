import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Branch;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final TypeReference<Map<String, Map<String, Branch>>> ANALYTICS_TYPE = new TypeReference<>() {
    };

    public Map<String, Map<String, Branch>> parseRawBranchesByYear(String json) {
        try {
            return MAPPER.readValue(json, ANALYTICS_TYPE);
        } catch (DatabindException e) {
            System.out.println("Failed to read analytics data. Databind exception");
            e.printStackTrace();
            return Collections.emptyMap();
        } catch (JsonProcessingException e) {
            System.out.println("Failed to read analytics data. Invalid JSON format");
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, Map<String, Branch>> parseBranchesByYear(String fileName) {
        InputStream fileData = getClass().getResourceAsStream(fileName);
        if(fileData != null) {
            String json = new Scanner(fileData, StandardCharsets.UTF_8).useDelimiter("\\A").next();
            return parseRawBranchesByYear(json);
        } else {
            System.out.println("Failed to find file named " + fileName);
            return null;
        }
    }
}
