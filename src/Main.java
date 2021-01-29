import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Logger Log = new Logger();
    private static RandomWordAPI WordAPI = new RandomWordAPI();
    private static Main main = new Main();

    // Let's the player decide whether the game should randomly generate a word
    // or if they choose to input one themselves.
    private int getGameWordConfig() {
        Scanner in = new Scanner(System.in);
        Log.Prompt("Before we start, would you like HangmanCLI to automatically select a word for you or do you want to select your own?\n\n[1] Automatically  [2] Select manually  (user input)");
        String line = in.nextLine();

        try {
            int option = Integer.parseInt(line);

            if(!(option > 0 && option <= 2)) {
                Log.Error("Invalid input \"" + line + "\" [1-2]");
                getGameWordConfig();
                return 0;
            }

            return option;
        } catch(Exception e) {
            Log.Error("Invalid input \"" + line + "\" [1-2]");
            getGameWordConfig();
            return 0;
        }
    }

    public static void promptPlayer(String word, String censoredWord, ArrayList<Character> guessedChars) throws Exception {
        Log.GameState(censoredWord, guessedChars);
        Scanner in = new Scanner(System.in);
        char guess = in.nextLine().toLowerCase().charAt(0);

        if(guessedChars.size() >= 7) {
            Log.GameOver(word);

            Scanner in2 = new Scanner(System.in);
            String res = in2.nextLine();

            if(res.length() == 0 || !(res.toLowerCase().charAt(0) + "").equals("n")) {
                startGame();
            }

            return;
        }

        // Check if guess is included in word or not.
        if(word.contains(guess+"")) {
            for(int i=0; i < censoredWord.length(); i++) {
                char character = word.charAt(i);
                if(guess == character) {
                    char[] chars = censoredWord.toCharArray();
                    chars[i] = guess;
                    censoredWord = String.valueOf(chars);
                }
            }

        } else if(!guessedChars.contains(guess)) {
            guessedChars.add(guess);
        }

        promptPlayer(word, censoredWord, guessedChars);
    }

    public static void startGame() throws Exception {
        String word = "";

        if(main.getGameWordConfig() == 1) {
            word = WordAPI.getWord();
        } else {
            Scanner in = new Scanner(System.in);
            Log.Prompt("Enter your desired word to start the game!  (user input)");
            word = in.nextLine();
        }

        String censoredWord = word.replaceAll("[^!.?\\s]", "_");
        ArrayList<Character> guessedChars = new ArrayList<>();

        promptPlayer(word, censoredWord, guessedChars);
    }

    public static void main(String[] args) throws Exception {
        startGame();
    }

}
