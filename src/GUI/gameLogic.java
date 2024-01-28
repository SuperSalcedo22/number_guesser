package GUI;

import java.util.ArrayList;

public class gameLogic {
    private int randomNumber;
    public int remainingTries;
    public boolean gameWon;
    public ArrayList<Integer> previousGuesses;

    public void startNewGame() {
        // Generate a random number between 1 and 100
        randomNumber = 1+(int)(100*Math.random()); //random number from 1-100
        System.out.print("The number is: "+randomNumber);
        remainingTries = 5;
        // stores the previous guesses
        previousGuesses = new ArrayList<>();
    }

    public String checkGuess(int userGuess) {

        // reduce the number of tries left and add it to the arraylist
        remainingTries--;
        previousGuesses.add(userGuess);

        // checks if the guess is correct or not
        if (userGuess == randomNumber) {
            gameWon=true;
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
