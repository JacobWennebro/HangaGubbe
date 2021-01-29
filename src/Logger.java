import java.util.ArrayList;
import java.util.Arrays;

public class Logger {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public String Space = "\n\n\n\n\n\n\n\n";

    public void Success(String text) {
        System.out.println(Space + ANSI_GREEN + text + ANSI_WHITE);
    }

    public void Prompt(String text) {
        System.out.println(Space + ANSI_CYAN + text + ANSI_WHITE);
    }

    public void GameState(String censoredWord, ArrayList<Character> guessedWords) {
        System.out.println(ANSI_GREEN + Space +"Word: " + censoredWord + "\n\n" + ANSI_RED + "Wrong guesses (" + guessedWords.size() + " out of 8): " + guessedWords.toString() + "\n\n" + ANSI_CYAN + "Guess a new letter that has not yet been guessed!");
    }

    public void GameOver(String word) {
        System.out.println(ANSI_GREEN + Space + ANSI_RED + "GAME OVER\n\nThe word was \"" + word + "\"\n\n" + ANSI_GREEN + "Would you like to start a new game? (Y/n)");
    }

    public void Error(String text) {
        System.out.println(ANSI_RED + text + ANSI_WHITE);
    }
}
