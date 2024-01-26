package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class gameGUI extends JFrame {

    public JTextField enteredName;
    private JLabel guessText, guessHistory;
    private JFormattedTextField numberGuess;
    public gameLogic game;
    private int guessValue;
    private String result;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public gameGUI() {
        JPanel startPanel = new JPanel();
        JPanel playPanel = new JPanel();
        JPanel gameOverPanel = new JPanel();

        // variables for the frame/window
        setTitle("Number guessing game");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // variables for the startPanel
        startPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        startPanel.setBackground(Color.black);

        // title label
        gbc.gridx=0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy=0;
        JLabel welcomeTitle = new JLabel("Welcome to the number guessing game");
        welcomeTitle.setFont(new Font("Helvetica",Font.BOLD,24));
        welcomeTitle.setForeground(Color.GREEN);
        welcomeTitle.setHorizontalAlignment(JLabel.CENTER);
        welcomeTitle.setVerticalAlignment(JLabel.CENTER);
        welcomeTitle.setPreferredSize(new Dimension(600,50));
        startPanel.add(welcomeTitle,gbc);

        // label asking for the name of the person
        gbc.gridy=1;
        JLabel askName = new JLabel("Enter name:");
        askName.setFont(new Font("Cambria",Font.PLAIN,20));
        askName.setForeground(Color.GREEN);
        askName.setHorizontalAlignment(JLabel.CENTER);
        askName.setVerticalAlignment(JLabel.CENTER);
        askName.setPreferredSize(new Dimension(600,50));
        startPanel.add(askName,gbc);

        // name input
        gbc.gridy=2;
        gbc.insets = new Insets(0,0,10,0);
        enteredName=new JTextField(20);
        enteredName.setFont(new Font("Cambria",Font.PLAIN,20));
        enteredName.setPreferredSize(new Dimension(200,25));
        startPanel.add(enteredName,gbc);

        // button to submit and start the next panel
        gbc.gridy=3;
        JButton nameSubmit = new JButton("Submit");
        nameSubmit.setPreferredSize(new Dimension(200,20));
        startPanel.add(nameSubmit,gbc);
        nameSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.startNewGame();
                cardLayout.show(cardPanel, "Panel2");
                guessText.setText("Guess the number " + enteredName.getText()+"!");
            }
        });

        // variables for the playPanel
        playPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc_play = new GridBagConstraints();
        playPanel.setBackground(Color.black);
        playPanel.setVisible(false);

        // shows the guess
        gbc_play.gridx=0;
        gbc_play.anchor = GridBagConstraints.CENTER;
        gbc_play.gridy=0;
        guessText = new JLabel("Text");
        guessText.setFont(new Font("Helvetica",Font.BOLD,24));
        guessText.setForeground(Color.GREEN);
        guessText.setHorizontalAlignment(JLabel.CENTER);
        guessText.setVerticalAlignment(JLabel.CENTER);
        guessText.setPreferredSize(new Dimension(600,50));
        playPanel.add(guessText,gbc_play);

        // shows the previous guesses
        gbc_play.gridy=1;
        guessHistory = new JLabel("It is an integer between 0-100");
        guessHistory.setFont(new Font("Cambria",Font.PLAIN,20));
        guessHistory.setForeground(Color.GREEN);
        guessHistory.setHorizontalAlignment(JLabel.CENTER);
        guessHistory.setVerticalAlignment(JLabel.CENTER);
        guessHistory.setPreferredSize(new Dimension(600,50));
        playPanel.add(guessHistory,gbc_play);

        // input for the guesses
        gbc_play.gridy=2;
        gbc_play.insets = new Insets(0,0,10,0);

        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        numberGuess = new JFormattedTextField(integerFormat);
        numberGuess.setColumns(10);

        numberGuess.setFont(new Font("Cambria",Font.PLAIN,20));
        numberGuess.setPreferredSize(new Dimension(200,25));
        playPanel.add(numberGuess,gbc_play);

        // button to submit number guess
        gbc_play.gridy=3;
        JButton numberSubmit = new JButton("Submit");
        numberSubmit.setPreferredSize(new Dimension(200,20));
        playPanel.add(numberSubmit,gbc_play);
        numberSubmit.addActionListener(e -> submitGuess());

        // variables for the gameOver panel
        gameOverPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc_over = new GridBagConstraints();
        gameOverPanel.setBackground(Color.black);

        // title label
        gbc_over.gridx=0;
        gbc_over.anchor = GridBagConstraints.CENTER;
        gbc_over.gridy=0;
        JLabel gameOverMsg = new JLabel("Place holder game over message");
        gameOverMsg.setFont(new Font("Helvetica",Font.BOLD,24));
        gameOverMsg.setForeground(Color.GREEN);
        gameOverMsg.setHorizontalAlignment(JLabel.CENTER);
        gameOverMsg.setVerticalAlignment(JLabel.CENTER);
        gameOverMsg.setPreferredSize(new Dimension(600,50));
        gameOverPanel.add(gameOverMsg,gbc_over);

        // previous guesses
        gbc_over.gridy=1;
        JLabel previousGuessesMsg = new JLabel("All guesses placeholder");
        previousGuessesMsg.setFont(new Font("Cambria",Font.PLAIN,20));
        previousGuessesMsg.setForeground(Color.GREEN);
        previousGuessesMsg.setHorizontalAlignment(JLabel.CENTER);
        previousGuessesMsg.setVerticalAlignment(JLabel.CENTER);
        previousGuessesMsg.setPreferredSize(new Dimension(600,50));
        gameOverPanel.add(previousGuessesMsg,gbc_over);

        // would you like to play again message
        gbc_over.gridy=2;
        gbc_over.insets = new Insets(0,0,10,0);
        JLabel playAgainMsg = new JLabel("Would you like to play again?");
        playAgainMsg.setFont(new Font("Cambria",Font.PLAIN,20));
        playAgainMsg.setForeground(Color.GREEN);
        playAgainMsg.setHorizontalAlignment(JLabel.CENTER);
        playAgainMsg.setVerticalAlignment(JLabel.CENTER);
        playAgainMsg.setPreferredSize(new Dimension(600,25));
        gameOverPanel.add(playAgainMsg,gbc_over);

        // button to play again
        gbc_over.gridy=3;
        gbc_over.insets = new Insets(0,0,0,200);
        JButton playAgain = new JButton("Yes");
        playAgain.setPreferredSize(new Dimension(90,20));
        gameOverPanel.add(playAgain,gbc_over);

        // button to end the game
        gbc_over.gridy=3;
        gbc_over.insets = new Insets(0,200,0,0);
        JButton endGame = new JButton("No");
        endGame.setPreferredSize(new Dimension(90,20));
        gameOverPanel.add(endGame,gbc_over);

        // adding the individual panels to the card panel
        cardPanel.add(startPanel, "Panel1");
        cardPanel.add(playPanel,"Panel2");
        cardPanel.add(gameOverPanel,"Panel3");
        // adding the card panel to the frame
        add(cardPanel);

        // setting the frame to be visible and creating an object of the game
        setVisible(true);
        game = new gameLogic();

    }

    private void submitGuess() {
        // linked to the button that submits the guessed number
        try {
            // attempt to convert the value into an integer
            guessValue = Integer.parseInt(numberGuess.getText());
        } catch (NumberFormatException ex) {
            // if not, pop up a message and make the guess 0
            JOptionPane.showMessageDialog(null, "Invalid input, setting to 0");
            guessValue = 0;
        }

        // uses the function to test if the value is correct or not
        result = game.checkGuess(guessValue, enteredName.getText());

        // if game over, switch to the game over panel, otherwise continue
        if (game.remainingTries==0) {
            // switch to the game over panel when there's no more tries
            cardLayout.show(cardPanel, "Panel3");
        } else {
            // shows on the screen if the person is correct or not
            guessText.setText(result);
            // displays the previous guesses to the user
            guessHistory.setText("Previous guesses " + game.previousGuesses.toString());
        }
    }

    private void genericPanelMaker() {
        // will be used as a method to create panels with less code
    }

    public static void main(String[] args) {
        // starting the whole program
        SwingUtilities.invokeLater(gameGUI::new);
    }
}
