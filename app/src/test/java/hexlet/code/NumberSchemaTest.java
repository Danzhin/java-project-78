package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    private final Validator VALIDATOR = new Validator();
    private NumberSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = VALIDATOR.number();
    }

    @Test
    public void testRequired() {
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testPositive() {
        assertTrue(schema.isValid(100));
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(-100));
        schema.positive();
        assertTrue(schema.isValid(100));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-100));
    }

    @Test
    public void testRange() {
        schema.range(-100, 100);
        assertFalse(schema.isValid(101));
        assertTrue(schema.isValid(0));
        assertFalse(schema.isValid(-101));
    }
}
