import com.java.tdd.numberValidator.NumberValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberValidatorTests {
    private static  NumberValidator numberValidator;

    @BeforeAll
    public static void setUp() {
        numberValidator = new NumberValidator();
    }

    @Test
    public void testIsPrime() {
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int primeNumber : primeNumbers)
            assertTrue(numberValidator.isPrime(primeNumber), primeNumber + " is not a prime number");
    }

    @Test
    public void testIsNotPrime() {
        int[] notPrimeNumbers = {1, 4, 8, 9};

        for (int notPrimeNumber : notPrimeNumbers)
            assertFalse(numberValidator.isPrime(notPrimeNumber), notPrimeNumber + " is a prime number");
    }
}
