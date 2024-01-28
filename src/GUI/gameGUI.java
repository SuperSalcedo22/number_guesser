package GUI;

import javax.swing.*;
import java.awt.*;

public class gameGUI extends JFrame {

    public JPanel cardPanel;
    public CardLayout cardLayout;
    public customPanel startPanel;
    private gameLogic game;

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

        startPanel = new customPanel(
                "Guess the number",
                "Its an integer between 0-100",
                "You have "+game.remainingTries+" attempts remaining",
                true,
                "Submit"
        );

        customPanel gameOverPanel = new customPanel(
                "Game over, you ran out of tries",
                "Previous guesses: "+game.previousGuesses,
                "Would you like to play again?",
                false,
                "No"
        );

        //add an action listener to the submit button
        startPanel.getSubmitButton().addActionListener(actionEvent -> {
            System.out.println("This works");
            accessNumberGuess();
        });

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

    // function linked to submit button to process the users input
    private void accessNumberGuess() {
        int guessValue;
        // attempt to get the value of the input and turn it into an integer, otherwise make 0
        try {
            guessValue = Integer.parseInt(startPanel.getSubmission());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input, setting to 0");
            guessValue = 0;
        }

        // gets the values and uses them to replace the values on the panel
        String result = game.checkGuess(guessValue);
        startPanel.setTitleText(result);
        startPanel.setSubtitleText("Previous guesses: "+game.previousGuesses);
        startPanel.setThirdText("You have "+game.remainingTries+" attempts remaining");
        startPanel.resetSpecialInputText();

        // test to see if the game is ended or not
        if (game.remainingTries==0) {
            cardLayout.show(cardPanel,"Panel2");
        }
    }

    public static void main(String[] args) {
        // starting the whole program
        SwingUtilities.invokeLater(gameGUI::new);
    }
}
