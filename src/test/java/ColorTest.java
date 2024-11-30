import org.example.Color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void testDefaultAlphaValue() {
        Color color = new Color(255, 0, 0);
        assertEquals(0, color.alpha());
    }

    @Test
    void testColorValues() {
        Color color = new Color(123, 45, 67, 89);
        assertEquals(123, color.red());
        assertEquals(45, color.green());
        assertEquals(67, color.blue());
        assertEquals(89, color.alpha());
    }

    @Test
    void testInvalidColorValues() {
        assertThrows(IllegalArgumentException.class, () -> new Color(300, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Color(0, -10, 0));
        assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, 0, 300));
    }
}
