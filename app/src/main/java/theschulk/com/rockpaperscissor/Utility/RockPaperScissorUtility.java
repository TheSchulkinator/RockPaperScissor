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

    //evaluate who winner is 0=tie, 1 = cpu, 2 user
    public static int evaluateWinner(int userSelection, int cpuSelection){
        //using index of game decide who won
        //game cycles so this method will reflect who the winner is
        int winningIndex = (3 + cpuSelection - userSelection) % 3;

        if(winningIndex == 0){
            //tie
            return 0;
        } else if (winningIndex == 1){
            //cpu wins
            return 1;
        } else {
            //user wins
            return 2;
        }
    }
}
