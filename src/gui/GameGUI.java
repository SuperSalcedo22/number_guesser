package gui;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {

    public JPanel cardPanel;
    public CardLayout cardLayout;
    public CustomPanel startPanel;
    public CustomPanel playPanel;
    public CustomPanel gameOverPanel;
    public CustomPanel gameStatsPanel;
    public GameLogic game;
    public String userName;

    public GameGUI() {

        // create instance of the game and start it
        game = new GameLogic();
        game.startNewGame();

        // variables for the frame/window
        setTitle("Number guessing game");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // creating the panels
        startPanel  = new CustomPanel(
                "Welcome to the number guessing game",
                "Built by SuperSalcedo22",
                "Please enter your name",
                true,
                "Submit"
        );

        playPanel = new CustomPanel(
                "Guess the number",
                "Its an integer between 0-100",
                "You have "+game.remainingTries+" attempts remaining",
                true,
                "Submit"
        );

        gameOverPanel = new CustomPanel(
                "Game over, you couldn't guess "+game.getRandomNumber(),
                "Previous guesses: "+game.previousGuesses,
                "Would you like to play again?",
                false,
                "No"
        );

        gameStatsPanel = new CustomPanel("Thanks for playing",
                "Games played:",
                "Games won:",
                false,
                "Close game"
        );
        gameStatsPanel.removeButton();

        // action listener that accesses the submitUserName method when clicking submit or enter
        startPanel.getSpecialInputField().addActionListener(actionEvent -> submitUserName());
        startPanel.getSubmitButton().addActionListener(actionEvent -> submitUserName());

        // action listener that accesses the submitNumberGuess method when clicking submit or enter
        playPanel.getSpecialInputField().addActionListener(actionEvent -> submitNumberGuess());
        playPanel.getSubmitButton().addActionListener(actionEvent -> submitNumberGuess());

        // action listener on submit button on the gameOver panel to restart the game
        gameOverPanel.getButtonYes().addActionListener(actionEvent -> startNewGame());

        // moves the player to the statsPanel and displays the stats
        gameOverPanel.getSubmitButton().addActionListener( actionEvent -> {
            cardLayout.show(cardPanel, "Panel4");
            gameStatsPanel.setTitleText("Thanks for playing "+userName);
            gameStatsPanel.setSubtitleText(game.numberOfGamesPlayed+" games played");
            gameStatsPanel.setThirdText(game.numberOfGamesWon+" games won");
        });

        // action listener to the no button to exit the game completely
        gameStatsPanel.getSubmitButton().addActionListener(actionEvent -> System.exit(0));

        // adding the individual panels to the card panel
        cardPanel.add(startPanel, "Panel1");
        cardPanel.add(playPanel, "Panel2");
        cardPanel.add(gameOverPanel,"Panel3");
        cardPanel.add(gameStatsPanel,"Panel4");
        // adding the card panel to the frame
        add(cardPanel);

        // setting the frame to be visible
        setVisible(true);
    }

    private void submitUserName() {
        // switches to the playPanel and saves the username to a variable
        cardLayout.show(cardPanel, "Panel2");
        userName = startPanel.getSubmissionText();
    }

    // method linked to submit button to process the users input
    private void accessNumberGuess() {
        int guessValue;
        String guessString=playPanel.getSubmissionText();
        // attempt to get the value of the input and turn it into an integer, otherwise make 0
        try {
            guessValue = Integer.parseInt(guessString);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input, setting to 0");
            guessValue = 0;
        }

        // gets the values and uses them to replace the values on the panel
        String result = game.checkGuess(guessValue);
        playPanel.setTitleText(result);
        playPanel.setSubtitleText("Previous guesses: "+game.previousGuesses);
        playPanel.setThirdText("You have "+game.remainingTries+" attempts remaining");

        // test to see if the game is ended or not
        if (game.gameWon) {
            switchToGameOverPanel();
            gameOverPanel.setTitleText(result);
        } else if(game.remainingTries==0) {
            switchToGameOverPanel();
        }
    }

    private void submitNumberGuess() {
        // access the number guess and reset the input field to nothing
        accessNumberGuess();
        playPanel.resetSpecialInputText();
    }

    public void startNewGame() {
        // Resets the game state to allow another game to be played
        game.startNewGame();

        // Update the playPanel to when it was first generated
        cardLayout.show(cardPanel, "Panel2");
        playPanel.setTitleText("Guess the number");
        playPanel.setSubtitleText("Its an integer between 0-100");
        playPanel.setThirdText("You have " + game.remainingTries + " attempts remaining");
        playPanel.resetSpecialInputText();

        // reset the gameOverPanel to show the new generated number
        gameOverPanel.setTitleText("Game over, you couldn't guess "+game.getRandomNumber());
    }

    // method that switches to the gameOverPanel when the condition is met
    public void switchToGameOverPanel() {
        // open the final panel
        cardLayout.show(cardPanel,"Panel3");
        gameOverPanel.setSubtitleText("Previous guesses: "+game.previousGuesses);
        gameOverPanel.setThirdText("Play again?");
    }

    public static void main(String[] args) {
        // starting the whole program
        SwingUtilities.invokeLater(GameGUI::new);
    }
}
