package cliAndMenus;

import Player.Player;
import cliAndMenus.Menus.*;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

import static JSON.jsonForGame.jsonForGame.jsonFileMakerForGame;
import static JSON.jsonForPlayers.jsonForPlayers.jsonTofilePlayer;
import static cliAndMenus.Menus.myCollections.getALLCardsExistingInGame;

public class gameCLI {

    /** I made this class singlton because I just want one Instance of it and also the current player field in it  */
    private static gameCLI gameCli = new gameCLI();
    public gameCLI(){}
    public static gameCLI getInstance(){
        return gameCli;
    }
  //  @Expose ArrayList ALLCardsExistingInGame = getALLCardsExistingInGame();

   Player currentPlayer = new Player();
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public  void startTheApp() throws IOException {
        System.out.println(" ******************************** \n      **** HEARTH STONE ****      \n ********************************");
        Scanner scanner = new Scanner(System.in);
      o :  while (true){
          System.out.println("already have an account?(yes/no/exit/exit_all)");
            switch (scanner.nextLine()) {
                case "yes":
                    gameCli.currentPlayer.Signin();
                    goToMenus();
                    break o;
                case "no":
                    gameCli.currentPlayer.Signup();
                    goToMenus();
                    break o;
                case "exit":
                    exit();
                    break o;
                case "exit_all":
                    exit_all();
                    break o;
                default:
                    System.out.println("Your input is not valid! ");
                    gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input  IN_LINE:48");
            }
        }
    }

    public void goToMenus() throws IOException {
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"OPENED_MENUS");
       o : while (true) {
            System.out.println("which *Menu*  do you want to go(collections/store)?" + "\n"+ "(exit/exit_all/delete_player/help)");
            Scanner scanner = new Scanner(System.in);
            String MenuName = scanner.nextLine();
            switch (MenuName) {
                case "collections":
                    myCollections.getInstance().goToCollectionsMenu();
                    break o;
                case "store":
                    Store.getInstance().goToStoreMenu();
                    break o;
                case "exit":
                    exit();
                    break o;
                case "exit_all":
                    exit_all();
                    break o;
                case "help":
                    help();
                    break o;
                case "delete_player":
                    gameCli.getCurrentPlayer().deleteThePlayer();
                    break o;
                default:{
                    System.out.println("invalid Menu name! Try again..");
                    gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input  IN_LINE:80");
                }
            }
        }
    }

    public void exit() throws IOException {
        System.out.println("Are you sure? this will exit the game, sign you out and start the app again (yes/no)");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.next();
            if (answer.equals("yes")) {
                jsonTofilePlayer(gameCLI.getInstance().currentPlayer);
                jsonFileMakerForGame(gameCLI.getInstance());
                startTheApp();
                break;
            }
            if (answer.equals("no")){
                goToMenus();
            }
            else {
                System.out.println("Your input is not valid! Enter yes or no :  type (yes/no)");
            }
        }
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"EXITED");
    }

    public static void exit_all() throws IOException {
        jsonTofilePlayer(gameCLI.getInstance().currentPlayer);
        jsonFileMakerForGame(gameCLI.getInstance());
        System.exit(0);
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"EXITED_ALL");
    }

    public void help() throws IOException {
        System.out.println("collections : this will show the game collection and your collection  of cards and heroes in game \n store : a place to buy or sell cards!! \n  exit : this will exit the game, sign you out and start the app again \n exit_all : this will exit you from the app \n  deleteThePlayer : this wil delete your account \n ");
        goToMenus();
    }


    //TODO : add a quick menu which uses all the methods instantly without guiding user so much

}
