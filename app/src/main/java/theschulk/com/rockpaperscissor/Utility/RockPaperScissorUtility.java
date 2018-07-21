package theschulk.com.rockpaperscissor.Utility;

import java.util.Random;

public class RockPaperScissorUtility {

    //create random number for computer selection 0-2
    //0=rock, 1=paper, 2=scissor
    public static int createRandomNumber(){
        Random random = new Random();
        int randomInt = random.nextInt(3);
        return randomInt;
    }
}
