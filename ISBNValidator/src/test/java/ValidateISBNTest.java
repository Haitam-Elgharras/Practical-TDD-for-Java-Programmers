import com.java.tdd.ValidateISBN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidateISBNTest {

    @Test
    public void ValidateISBN_CheckAValid10DigitISBN_ReturnsTrue() {
        ValidateISBN validator = new ValidateISBN();

        boolean result = validator.checkISBN(140449116);

        assertTrue(result);
    }
}
