package GUI;

import java.util.ArrayList;

public class gameLogic {
    private int randomNumber;
    public int remainingTries;
    public int gamesPlayed=0;
    public int gamesWon=0;
    public ArrayList<Integer> previousGuesses;

    public void startNewGame() {
        // Generate a random number between 1 and 100
        randomNumber = 1+(int)(100*Math.random()); //random number from 1-100
        System.out.print("The number is: "+randomNumber);
        remainingTries = 5;
        // stores the previous guesses
        previousGuesses = new ArrayList<>();
        gamesPlayed++;
    }

    public String checkGuess(int userGuess, String userName) {
        remainingTries--;
        previousGuesses.add(userGuess);

        // checks if the guess is correct or not
        if (userGuess == randomNumber) {
            gamesWon++;
            return "Congratulations, " + userName + "! Your guess is correct.";
        } else if (remainingTries == 0) {
            return "Sorry, " + userName + "! You've run out of tries. The correct number was " + randomNumber;
        } else if (userGuess < randomNumber) {
            return "Try a higher number. Tries left: " + remainingTries;
        } else {
            return "Try a lower number. Tries left: " + remainingTries;
        }
    }
}
