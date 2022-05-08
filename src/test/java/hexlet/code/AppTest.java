package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void validateStringTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertEquals(true, schema.isValid(""));
        assertEquals(true, schema.isValid(null));
        assertEquals(true,  schema.isValid("what does the fox say"));
        //assertEquals(false,  schema.isValid(6));
        assertEquals(false,  schema.isValid('f'));

        schema.required();

       // assertEquals(false,  schema.isValid(6));
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
        assertEquals(true, schema.contains("").isValid(""));
        // assertEquals(false, schema.contains(5).isValid(6));
        // assertEquals(false, schema.contains('5').isValid(6));

       // assertEquals(true, schema.minLength(5).isValid("what does the fox say"));
       // assertEquals(true, schema.minLength(0).isValid(""));
       // assertEquals(false, schema.minLength(0).isValid(null));

    }
}
