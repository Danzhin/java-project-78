package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapSchemaTest {

    private final Validator validator = new Validator();
    private MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = validator.map();
    }

    @Test
    public void requiredTest() {
        schema.required();
        assertTrue(schema.isValid(Map.of("key1", "value1")));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void sizeofTest() {
        schema.sizeof(1);
        assertTrue(schema.isValid(Map.of("key1", "value1")));
        assertFalse(schema.isValid(Map.of()));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void shapeTest() {
        schema.shape(Map.of("key1", validator.string().required()));
        assertTrue(schema.isValid(Map.of("key1", "value1")));
        assertFalse(schema.isValid(Map.of("key1", "")));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void combinationTest() {
        schema.required().sizeof(1).shape(Map.of("key1", validator.string().required()));
        assertTrue(schema.isValid(Map.of("key1", "value1")));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(Map.of()));
        assertFalse(schema.isValid(Map.of("key1", "")));
    }

}
