package theschulk.com.rockpaperscissor;

import org.junit.Test;
import static org.junit.Assert.*;

import static theschulk.com.rockpaperscissor.Utility.RockPaperScissorUtility.createRandomNumber;

public class RandomUnitTest {
    @Test
    public void testCreateRandomNumber(){
        int random = createRandomNumber();
        int lowValue = 0;
        int highValue = 2;

        assertTrue(random >= lowValue);
        assertTrue(random <= highValue);
    }
}
