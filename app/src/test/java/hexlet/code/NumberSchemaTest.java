package hexlet.code;

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
    public void testRequired() {
        schema.required();
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testPositive() {
        schema.positive();
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-1));
    }

    @Test
    public void testRange() {
        schema.range(0, 1);
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(-1));
        assertFalse(schema.isValid(2));
    }

}
