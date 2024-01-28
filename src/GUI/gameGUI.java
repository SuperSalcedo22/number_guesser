package GUI;

import javax.swing.*;
import java.awt.*;

public class gameGUI extends JFrame {

    public JPanel cardPanel;
    public CardLayout cardLayout;
    public customPanel startPanel;
    public customPanel gameOverPanel;
    public gameLogic game;

    public gameGUI() {

        // create instance of the game and start it
        game = new gameLogic();
        game.startNewGame();

        // variables for the frame/window
        setTitle("Number guessing game");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // creating the panels
        startPanel = new customPanel(
                "Guess the number",
                "Its an integer between 0-100",
                "You have "+game.remainingTries+" attempts remaining",
                true,
                "Submit"
        );

        gameOverPanel = new customPanel(
                "Game over, you couldn't guess "+game.getRandomNumber(),
                "Previous guesses: "+game.previousGuesses,
                "Would you like to play again?",
                false,
                "No"
        );

        //add an action listener to the submit button on the start panel to check the guess
        startPanel.getSubmitButton().addActionListener(actionEvent -> {
            System.out.println("This works");
            accessNumberGuess();
            startPanel.resetSpecialInputText();
        });

        // add an action listener on submit button on the final panel to restart the game
        gameOverPanel.getButtonYes().addActionListener(actionEvent -> startNewGame());

        // add an action listener to the no button to exit the game
        gameOverPanel.getSubmitButton().addActionListener( actionEvent -> System.exit(0));

        // adding the individual panels to the card panel
        cardPanel.add(startPanel, "Panel1");
        cardPanel.add(gameOverPanel,"Panel2");
        // adding the card panel to the frame
        add(cardPanel);

        // setting the frame to be visible
        setVisible(true);
    }

    // method linked to submit button to process the users input
    private void accessNumberGuess() {
        int guessValue;
        String guessString=startPanel.getSubmission();
        // attempt to get the value of the input and turn it into an integer, otherwise make 0
        try {
            guessValue = Integer.parseInt(guessString);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input, setting to 0");
            guessValue = 0;
        }

        // gets the values and uses them to replace the values on the panel
        String result = game.checkGuess(guessValue);
        startPanel.setTitleText(result);
        startPanel.setSubtitleText("Previous guesses: "+game.previousGuesses);
        startPanel.setThirdText("You have "+game.remainingTries+" attempts remaining");

        // test to see if the game is ended or not
        if (game.gameWon) {
            switchToFinalScreen();
            gameOverPanel.setTitleText(result);
        } else if(game.remainingTries==0) {
            switchToFinalScreen();
        }
    }

    public void startNewGame() {
        // Resets the game state to allow another game to be played
        game.startNewGame();

        // Update the UI to when it was first generated
        cardLayout.show(cardPanel, "Panel1");
        startPanel.setTitleText("Guess the number");
        startPanel.setSubtitleText("Its an integer between 0-100");
        startPanel.setThirdText("You have " + game.remainingTries + " attempts remaining");
        startPanel.resetSpecialInputText();

        // reset the gameOverPanel to show the new generated number
        gameOverPanel.setTitleText("Game over, you couldn't guess "+game.getRandomNumber());
    }

    // method that switches to the gameOverPanel when the condition is met
    public void switchToFinalScreen () {
        // open the final panel
        cardLayout.show(cardPanel,"Panel2");
        gameOverPanel.setSubtitleText("Previous guesses: "+game.previousGuesses);
        gameOverPanel.setThirdText("Play again?");
    }

    public static void main(String[] args) {
        // starting the whole program
        SwingUtilities.invokeLater(gameGUI::new);
    }
}
