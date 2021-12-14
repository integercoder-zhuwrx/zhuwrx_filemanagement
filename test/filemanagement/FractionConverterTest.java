package filemanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionConverterTest {
    @Test
    void parseToDouble() {
        double[] values = FractionConverter.parseToDouble("-1/2;5/4;-171/50;0/1");
        assertArrayEquals(new double[]{-0.5, 1.25, -3.42, 0.0}, values);
    }

    @Test
    void fractionToDouble() {
        double value = FractionConverter.fractionToDouble("-171/50");
        assertEquals(-3.42, value);
    }

    @Test
    void gcd() {
        int g = FractionConverter.gcd(7 * 5, 7 * 11);
        assertEquals(7, g);
    }

    @Test
    void parseToString() {
        String text = FractionConverter.parseToString(new double[]{-0.5, 1.25, -3.42, 0.0});
        assertEquals("-1/2;5/4;-171/50;0/1", text);
    }

    @Test
    void doubleToFraction() {
        String text = FractionConverter.doubleToFraction(-3.42);
        assertEquals("-171/50", text);
    }
}
