import java.util.Scanner;
import java.util.ArrayList;
public class guessingGame {

    public static void higherOrLower(int number, int guess) {
        if (number>guess) {
            System.out.println(guess+" is lower than the random number");
        } else {
            System.out.println(guess + " is higher than the random number");
        }
    }

    public static void guessingNumberGame(Scanner scanner) {
        System.out.println("Welcome to the number guessing game");

        // defining the variables needed for the start of the game
        int number = 1+(int)(100*Math.random()); //random number from 1-100
        int userInput=0;
        int numberOfGuesses = 5;
        ArrayList<Integer> previousGuesses = new ArrayList<>();// creates the arraylist of previous guesses

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
                    return;
                } else {
                    System.out.println("Wrong number! Keep trying!");
                    higherOrLower(number,userInput);
                }

            } catch (java.util.InputMismatchException e) {
                // catches if the input was invalid and assigns it to zero
                System.out.println("This is not a valid integer, setting guess attempt to 0");
                // Clear the invalid input from the scanner
                scanner.nextLine();
                userInput = 0;
            } finally {
                // adds to the list
                previousGuesses.add(userInput);
                System.out.println("Guesses used: "+i+", "+previousGuesses);
                if (numberOfGuesses == i) {
                    System.out.println("You ran of guesses, the correct number was "+number);
                }
            }
        }
        System.out.println("Game over");

        // close the scanner to release the resource at the end
        scanner.close();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            guessingNumberGame(scanner);
            System.out.print("Would you like to play again? (y/n): ");
            String replayInput = scanner.next();

            if (!replayInput.equalsIgnoreCase("y")) {
                System.out.print("Thanks for playing");
                break;
            }
        }
    }
}