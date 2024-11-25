package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    private final Validator validator = new Validator();
    private NumberSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = validator.number();
    }

    @Test
    public void requiredTest() {
        schema.required();
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void positiveTest() {
        schema.positive();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(0));
    }

    @Test
    public void rangeTest() {
        schema.range(0, 1);
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(2));
    }

    @Test
    public void combinationTest() {
        schema.required().positive().range(0, 1);
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(2));
    }

}
