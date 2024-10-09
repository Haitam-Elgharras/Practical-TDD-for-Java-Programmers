import com.java.tdd.BowlingScoreCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingScoreCalculatorTest {

    private BowlingScoreCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new BowlingScoreCalculator();
    }

    @Test
    public void calculateScore_GutterGame_Zero() {
        assertEquals(0, calculator.calculateScore(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    public void calculateScore_TenPairsOfNineAndMiss_NineTeen() {
        assertEquals(90, calculator.calculateScore(0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9));
    }

    @Test
    public void calculateScore_OneSpareAndThreeInNextRoll_SixTeen() {
        assertEquals(16, calculator.calculateScore(5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    public void calculateScore_AllSpares_OneHundredFifty() {
        assertEquals(150, calculator.calculateScore(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));
    }

    @Test
    public void calculateScore_TheLastFrameIsAStrike() {
        assertEquals(30, calculator.calculateScore(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10));
    }

    @Test
    public void calculateScore_AllStrikes_ThreeHundred() {
        assertEquals(300, calculator.calculateScore(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
    }

}
