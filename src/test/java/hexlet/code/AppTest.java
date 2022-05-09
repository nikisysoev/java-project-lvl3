package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int ZERO = 0;

    @Test
    void validateStringTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertEquals(true, schema.isValid(""));
        assertEquals(true, schema.isValid(null));
        assertEquals(true,  schema.isValid("what does the fox say"));
        assertEquals(false,  schema.isValid(SIX));
        assertEquals(false,  schema.isValid('f'));

        schema.required();

        assertEquals(false,  schema.isValid(SIX));
        assertEquals(false,  schema.isValid('f'));
        assertEquals(true,  schema.isValid("what does the fox say"));
        assertEquals(true, schema.isValid("hexlet"));
        assertEquals(false, schema.isValid(null));
        assertEquals(false, schema.isValid(""));

        assertEquals(true, schema.contains("what").isValid("what does the fox say"));
        assertEquals(false, schema.contains("whatthe").isValid("what does the fox say"));
        assertEquals(false,  schema.isValid("what does the fox say"));
        assertEquals(false, schema.contains(null).isValid("what does the fox say"));
        assertEquals(false, schema.contains(null).isValid(null));
        assertEquals(true, schema.contains("").isValid("what does the fox say"));
        assertEquals(true, schema.contains("").isValid("7"));

        assertEquals(true, schema.minLength(FIVE).isValid("what does the fox say"));
        assertEquals(true, schema.minLength(ZERO).isValid("5"));
        assertEquals(false, schema.minLength(ZERO).isValid(null));
    }

    @Test
    void validateNumberTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertEquals(true, schema.isValid(null));
        assertEquals(false, schema.isValid("567"));

        schema.required();

        assertEquals(true, schema.isValid(SIX));
        assertEquals(false, schema.isValid("567"));
        assertEquals(false, schema.isValid(null));

        assertEquals(true, schema.positive().isValid(SIX));
        assertEquals(false, schema.isValid(-SIX));

        schema.range(FIVE, SIX);

        assertEquals(true, schema.isValid(SIX));
        assertEquals(true, schema.isValid(SIX));
        assertEquals(false,  schema.isValid(ZERO));
        assertEquals(false,  schema.isValid(-SIX));
    }
}
