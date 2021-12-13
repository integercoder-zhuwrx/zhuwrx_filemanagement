package filemanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionConverterTest {
    private FractionConverter fc = new FractionConverter();

    @Test
    void parseToDouble() {
        double[] values = fc.parseToDouble("-1/2;5/4;-171/50;0/1");
        assertArrayEquals(new double[]{-0.5, 1.25, -3.42, 0.0}, values);
    }

    @Test
    void fractionToDouble() {
        double value = fc.fractionToDouble("-171/50");
        assertEquals(-3.42, value);
    }

    @Test
    void gcd() {
        int g = fc.gcd(7 * 5, 7 * 11);
        assertEquals(7, g);
    }

    @Test
    void parseToString() {
        String text = fc.parseToString(new double[]{-0.5, 1.25, -3.42, 0.0});
        assertEquals("-1/2;5/4;-171/50;0/1", text);
    }

    @Test
    void doubleToFraction() {
        String text = fc.doubleToFraction(-3.42);
        assertEquals("-171/50", text);
    }
}
