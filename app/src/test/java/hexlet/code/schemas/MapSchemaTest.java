package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    private final Validator validator = new Validator();
    private MapSchema<String, String> schema;

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
    public void testShape() {
        schema.shape(Map.of("name", validator.string().required()));
        assertTrue(schema.isValid(Map.of("name", "John")));
        assertFalse(schema.isValid(Map.of("name", "")));
    }

}
