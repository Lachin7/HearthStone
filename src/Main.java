import cliAndMenus.gameCLI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        gameCLI gamecli = gameCLI.getInstance();
        gamecli.startTheApp();
    }
}
