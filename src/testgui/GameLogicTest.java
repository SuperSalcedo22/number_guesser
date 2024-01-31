package testgui;

import gui.GameLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    @Test
    void testStartNewGame() {
        GameLogic game = new GameLogic();
        game.startNewGame();

        // random number is within the range
        assertTrue(game.getRandomNumber() >= 1 && game.getRandomNumber() <= 100);

        // remainingTries is instantiated properly
        assertEquals(5,game.remainingTries);

        // gameWon is not true
        assertFalse(game.gameWon);

        // numberOfGamesWon#
        assertEquals(0,game.numberOfGamesWon);

        // numberOfGamesPlayed
        assertEquals(1,game.numberOfGamesPlayed);

        // empty array
        assertTrue(game.previousGuesses.isEmpty());
    }

    @Test
    void testCheckGuessCorrect() {
        GameLogic game = new GameLogic();
        game.startNewGame();
        int correctNumber = game.getRandomNumber();
        String output = game.checkGuess(correctNumber);

        assertTrue(output.contains("Congratulations"));
        assertTrue(game.gameWon);
        assertEquals(4,game.remainingTries);
        assertEquals(1,game.previousGuesses.size());
        assertEquals(correctNumber,game.previousGuesses.get(0));
    }

    @Test
    void testCheckGuessHigh() {
        // ensure the guess is always above
        GameLogic game = new GameLogic();
        game.startNewGame();
        int correctNumber = game.getRandomNumber();
        String output = game.checkGuess(correctNumber+1);

        assertTrue(output.contains("lower"));
        assertFalse(game.gameWon);
        assertEquals(4,game.remainingTries);
        assertEquals(1,game.previousGuesses.size());
        assertEquals(correctNumber+1,game.previousGuesses.get(0));
    }

    @Test
    void testCheckGuessLow() {
        // ensure the guess is always below
        GameLogic game = new GameLogic();
        game.startNewGame();
        int correctNumber = game.getRandomNumber();
        String output = game.checkGuess(correctNumber-1);

        assertTrue(output.contains("higher"));
        assertFalse(game.gameWon);
        assertEquals(4,game.remainingTries);
        assertEquals(1,game.previousGuesses.size());
        assertEquals(correctNumber-1,game.previousGuesses.get(0));
    }

    @Test
    void testCheckGuessNoTriesLeft() {
        // ensure the guess is never correct
        GameLogic game = new GameLogic();
        game.startNewGame();
        int correctNumber = game.getRandomNumber();
        for (int i = 0; i < 4; i++) {
            // Make guesses without winning
            game.checkGuess(correctNumber+1);
        }
        // final guess to see what happens
        String result = game.checkGuess(correctNumber+1);

        assertTrue(result.contains("ran out"));
        assertFalse(game.gameWon);
        assertEquals(0,game.remainingTries);
        assertEquals(5,game.previousGuesses.size());
        assertEquals(correctNumber+1,game.previousGuesses.get(3));
    }
}