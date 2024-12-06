import org.example.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void testDefaultAlphaValue() {
        // Tworzenie koloru bez określonego alpha (domyślne = 0)
        Color color = new Color(255, 0, 0);
        assertEquals(0, color.getAlpha(), "Default alpha value should be 0");
    }

    @Test
    void testColorValues() {
        // Tworzenie koloru z pełnym zestawem wartości RGB i alpha
        Color color = new Color(123, 45, 67, 89);
        assertEquals(123, color.getRed(), "Red value mismatch");
        assertEquals(45, color.getGreen(), "Green value mismatch");
        assertEquals(67, color.getBlue(), "Blue value mismatch");
        assertEquals(89, color.getAlpha(), "Alpha value mismatch");
    }

    @Test
    void testInvalidColorValues() {
        // Sprawdzanie wyjątków dla nieprawidłowych wartości
        assertThrows(IllegalArgumentException.class, () -> new Color(300, 0, 0), "Red value out of range");
        assertThrows(IllegalArgumentException.class, () -> new Color(0, -10, 0), "Green value out of range");
        assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, 0, 300), "Alpha value out of range");
    }

    @Test
    void testEqualsAndHashCode() {
        // Testowanie poprawności metod equals i hashCode
        Color color1 = new Color(123, 45, 67, 89);
        Color color2 = new Color(123, 45, 67, 89);
        Color color3 = new Color(255, 0, 0, 255);

        assertEquals(color1, color2, "Equal objects should be considered equal");
        assertNotEquals(color1, color3, "Different objects should not be considered equal");

        assertEquals(color1.hashCode(), color2.hashCode(), "Equal objects should have the same hashCode");
        assertNotEquals(color1.hashCode(), color3.hashCode(), "Different objects should have different hashCodes");
    }

    @Test
    void testToString() {
        // Testowanie czy metoda toString zwraca odpowiednie wartości
        Color color = new Color(255, 100, 50, 200);
        String expected = "Color{red=255, green=100, blue=50, alpha=200}";
        assertEquals(expected, color.toString(), "toString method output mismatch");
    }
}
