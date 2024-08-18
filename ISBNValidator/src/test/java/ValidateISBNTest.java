import com.java.tdd.ValidateISBN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ValidateISBNTest {

    @Test
    public void ValidateISBN_CheckAValid10DigitISBN_ReturnsTrue() {
        ValidateISBN validator = new ValidateISBN();

        boolean result1 = validator.checkISBN(140449116);
        boolean result2 = validator.checkISBN(131016490);

        assertTrue(result1, "First value");
        assertTrue(result2, "Second value");
    }

    @Test
    public void ValidateISBN_CheckAnInvalid10DigitISBN_ReturnsFalse() {
        ValidateISBN validator = new ValidateISBN();

        boolean result = validator.checkISBN(140449117);

        assertFalse(result);
    }
}
