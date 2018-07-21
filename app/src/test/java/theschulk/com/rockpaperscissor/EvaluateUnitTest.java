package theschulk.com.rockpaperscissor;

import org.junit.Test;
import static org.junit.Assert.*;
import static theschulk.com.rockpaperscissor.Utility.RockPaperScissorUtility.evaluateWinner;

public class EvaluateUnitTest {
    @Test
    public void testEvaluateWinner(){
        int rock = 0;
        int paper = 1;
        int scissor = 2;

        int tie = 0;
        int cpuWin = 1;
        int userWin = 2;

        int actualTie = evaluateWinner(rock,rock);
        assertEquals(tie, actualTie);

        int actualCpuWin = evaluateWinner(rock,paper);
        assertEquals(cpuWin, actualCpuWin);

        int actualUserWin = evaluateWinner(scissor,paper);
        assertEquals(userWin,actualUserWin);
    }
}
