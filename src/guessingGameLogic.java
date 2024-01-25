import java.util.Scanner;
import java.util.ArrayList;
public class guessingGameLogic {

    public static void guessingNumberGame(Scanner scanner, int gamesWon) {

        // defining the variables needed for the start of the game
        int number = 1+(int)(100*Math.random()); //random number from 1-100
        int userInput=0;
        int numberOfGuesses = 5;
        // arraylist to store previous guesses
        ArrayList<Integer> previousGuesses = new ArrayList<>();

        System.out.println("You have "+numberOfGuesses+" number of guesses");

        // loops through the number of tries
        for (int i =1;i<=numberOfGuesses;i++) {
            // try block that catches if the number isn't an integer
            try {
                // gets the user input
                System.out.println("Please enter a integer number");
                userInput= scanner.nextInt();

                // checks the number is correct or not
                if (userInput==number) {
                    System.out.println("Congratulations, you guessed the number correctly!");
                    gamesWon++;
                    return;
                } else {
                    System.out.println("Wrong number! Keep trying!");
                    // if the number is too high or low
                    if (number>userInput) {
                        System.out.println(userInput+" is lower than the random number");
                    } else {
                        System.out.println(userInput + " is higher than the random number");
                    }
                }

            } catch (java.util.InputMismatchException e) {
                // catches if the input was invalid and assigns it to zero
                System.out.println("This is not a valid integer, setting guess attempt to 0");
                // Clear the invalid input from the scanner
                scanner.nextLine();
                userInput = 0;
            } finally {
                // adds to the previous guesses list
                previousGuesses.add(userInput);
                System.out.println("Guesses used: "+i+", "+previousGuesses);
                if (numberOfGuesses == i) {
                    System.out.println("You ran of guesses, the correct number was "+number);
                }
            }
        }
        System.out.println("Game over");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gamesPlayed = 0;
        int gamesWon = 0;
        System.out.println("Welcome to the number guessing game");

        // keep looping to allow multiple games to be played
        while (true) {
            guessingNumberGame(scanner, gamesWon);
            gamesPlayed++;
            System.out.print("Would you like to play again? (y): ");
            String replayInput = scanner.next();

            // ends the program if the player no longer wants to play
            if (!replayInput.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing");
                System.out.println("Total games played: "+gamesPlayed);
                System.out.println("Games won: "+gamesWon);
                break;
            } else {
                System.out.println("Starting another game");
            }
        }
        // Ensuring the scanner is closed
        scanner.close();
    }
}