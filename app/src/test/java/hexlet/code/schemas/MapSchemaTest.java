package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    private final Validator validator = new Validator();
    private MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = validator.map();
    }

    @Test
    public void testRequired() {
        schema.required();
        assertTrue(schema.isValid(Map.of()));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testSizeof() {
        schema.sizeof(2);
        assertTrue(schema.isValid(Map.of("key1", "value1", "key2", "value2")));
        assertFalse(schema.isValid(Map.of("key1", "value1")));
    }

    @Test
    public void testMapValidator() {
        var v = new Validator();
        var schema = v.map();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        schema.sizeof(2);
        assertFalse(schema.isValid(new HashMap<>()));
        Map<String, String> actual1 = new HashMap<>();
        actual1.put("key1", "value1");
        assertFalse(schema.isValid(actual1));
        actual1.put("key2", "value2");
        assertTrue(schema.isValid(actual1));

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required().contains("ya"));
        schemas.put("lastName", v.string().required().contains("ov"));
        schema.shape(schemas);

        Map<String, String> actual2 = new HashMap<>();
        actual2.put("firstName", "Kolya");
        actual2.put("lastName", "Ivanov");
        assertTrue(schema.isValid(actual2));

        Map<String, String> actual3 = new HashMap<>();
        actual3.put("firstName", "Maya");
        actual3.put("lastName", "Krasnova");
        assertTrue(schema.isValid(actual3));

        Map<String, String> actual4 = new HashMap<>();
        actual4.put("firstName", "John");
        actual4.put("lastName", "Jones");
        assertFalse(schema.isValid(actual4));
    }

}
