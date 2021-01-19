import java.io.IOException;
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

    // Method which initializes the game with the given word
    private void initGame(String word) {
        String censoredWord = word.replaceAll("[^!.?\\s]", " _ ");

        System.out.println(word + " " + censoredWord);
    }

    public static void main(String[] args) throws Exception {
        String word = "";

        if(main.getGameWordConfig() == 1) {
            word = WordAPI.getWord();
        } else {
            Scanner in = new Scanner(System.in);
            Log.Prompt("Enter your desired word to start the game!  (user input)");
            word = in.nextLine();
        }

        main.initGame(word);
    }

}
