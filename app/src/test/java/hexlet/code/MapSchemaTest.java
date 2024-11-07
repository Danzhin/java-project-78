package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertTrue(schema.isValid(Map.of()));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testSizeof() {
        schema.sizeof(1);
        assertTrue(schema.isValid(Map.of("key1", "value1")));
        assertFalse(schema.isValid(Map.of()));
    }

}
