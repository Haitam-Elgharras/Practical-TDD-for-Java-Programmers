import com.java.tdd.isbnValidator.ValidateISBN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ValidateISBNTest {

    private ValidateISBN validator;

    @BeforeEach
    public void init() {
        validator = new ValidateISBN();
    }

    //    MethodName_StateUnderTest_ExpectedBehavior eg: MethodName: checkISBN StateUnderTest: AValid10DigitISBN ExpectedBehavior: ReturnsTrue
    @Test
    public void checkISBN_AValidShortISBN_ReturnsTrue() {
        boolean result = validator.checkISBN("0140449116");
        assertTrue(result, "First value");

        result = validator.checkISBN("0131016490");
        assertTrue(result, "Second value");
    }

    @Test
    public void checkISBN_AValidLongISBN_ReturnTrue() {
        boolean result = validator.checkISBN("9780735211292");

        assertTrue(result);
    }

    @Test
    public void checkISBN_AnInvalidShortISBN_ReturnsFalse() {
        boolean result = validator.checkISBN("0140449117");

        assertFalse(result);
    }

    @Test
    public void checkISBN_AnInvalidLongISBN_ReturnsFalse() {
        boolean result = validator.checkISBN("0000000000001");

        assertFalse(result);
    }

    @Test
    public void checkISBN_AValidShortISBNWithX_ReturnTrue() {
        assertTrue(validator.checkISBN("012000030X"));
    }

    @Test
    public void checkISBN_IncorrectLengthISBN_ThrowAnException() {
        assertThrows(NumberFormatException.class, ()->validator.checkISBN("123456789"));
    }

    @Test
    public void checkISBN_NonNumericISBN_ThrowAnException() {
        assertThrows(NumberFormatException.class,()->validator.checkISBN("helloworld"));
        assertThrows(NumberFormatException.class,()->validator.checkISBN("978073521129X"));
    }

}
