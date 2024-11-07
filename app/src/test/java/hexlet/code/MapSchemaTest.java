package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    private final Validator VALIDATOR = new Validator();
    private MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = VALIDATOR.map();
    }

    @Test
    public void testRequired() {
        schema.required();
        Map<String, String> map = new HashMap<>();
        assertTrue(schema.isValid(map));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testSizeof() {
        schema.sizeof(1);
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        assertTrue(schema.isValid(map));
        map.remove("key1");
        assertFalse(schema.isValid(map));
    }

}
