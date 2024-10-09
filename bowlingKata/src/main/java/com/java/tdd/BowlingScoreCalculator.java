package com.java.tdd;

public class BowlingScoreCalculator {
    private int score=0;
    private int[] arrayRolls = new int[21];

    // the user will give us a list of rolls, and we will return the score of the game
    public int calculateScore(int...rolls) {
        saveRolls(rolls);

        int counter = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(counter)){
                score += 10 + arrayRolls[counter+1] + arrayRolls[counter+2];
                counter++;
                continue;
            }
            else if (isSpare(counter)) {
                score += 10 + arrayRolls[counter+2];
            }
            else {
                score+= arrayRolls[counter] + arrayRolls[counter+1];
            }
            counter+=2;
        }

        return score;
    }

    private boolean isSpare(int counter) {
        return arrayRolls[counter] + arrayRolls[counter + 1] == 10;
    }

    private boolean isStrike(int counter) {
        return arrayRolls[counter] == 10;
    }

    private void saveRolls(int[] rolls) {
        int counter = 0;
        for (int pins : rolls)
            arrayRolls[counter++]=pins;
    }

}
