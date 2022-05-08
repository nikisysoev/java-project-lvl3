package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void helloTest() {
        assertEquals("Hello", App.hello());
    }
}
