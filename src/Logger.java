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

    public void Success(String text) {
        System.out.println(ANSI_GREEN + text + ANSI_WHITE);
    }

    public void Prompt(String text) {
        System.out.println(ANSI_CYAN + text + ANSI_WHITE);
    }

    public void Error(String text) {
        System.out.println(ANSI_RED + text + ANSI_WHITE);
    }
}
