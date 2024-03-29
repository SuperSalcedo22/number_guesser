package gui;

import java.util.ArrayList;

public class GameLogic {
    private int randomNumber;
    public int remainingTries;
    public boolean gameWon;
    public int numberOfGamesWon;
    public int numberOfGamesPlayed;
    public ArrayList<Integer> previousGuesses;

    public void startNewGame() {
        // Generate a random number between 1 and 100
        randomNumber = 1+(int)(100*Math.random()); //random number from 1-100
        numberOfGamesPlayed++;
        remainingTries = 5;
        // stores the previous guesses
        previousGuesses = new ArrayList<>();
    }

    public String checkGuess(int userGuess) {

        // reduce the number of tries left and add the guess to the arraylist
        remainingTries--;
        previousGuesses.add(userGuess);

        // checks if the guess is correct or not
        if (userGuess == randomNumber) {
            gameWon=true;
            numberOfGamesWon++;
            return "Congratulations! Your guess is correct.";
        } else if (remainingTries == 0) {
            return "You ran out of tries. It was " + randomNumber;
        } else if (userGuess < randomNumber) {
            return "Try a higher number. Tries left: " + remainingTries;
        } else {
            return "Try a lower number. Tries left: " + remainingTries;
        }
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
