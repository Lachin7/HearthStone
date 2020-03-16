package cliAndMenus;

import Player.Player;
import java.util.Scanner;
import static cliAndMenus.Menus.Collections.goToCollectionsMenu;
import static cliAndMenus.Menus.Store.goToStoreMenu;

public class gameCLI extends Player{
    /** I made this class singlton because I just want one Instance of it and also the current player field in it  */
    private static gameCLI gameCli = new gameCLI();
    Player currentPlayer = new Player();
    private gameCLI(){
        this.currentPlayer = currentPlayer;
    }
    public static gameCLI getInstance(){
        return gameCli;
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void startTheApp(){
        System.out.println("********************** \n **** HEARTH STONE **** \n **********************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("already have an account?(yes/no/exit/exit_all)");
        Boolean isValidInput = false;
        while (!isValidInput){
            switch (scanner.nextLine()){
                case "yes":
                    gameCli.currentPlayer.Signin();
                    goToCardMenus();
                    isValidInput = true;
                    break;
                case "no":
                    gameCli.currentPlayer.Signup();
                    goToCardMenus();
                    isValidInput = true;
                    break;
                case "exit":
                    exit();
                    break;
                case "exit_all":
                    exit_all();
                    break;
                default:
                    System.out.println("Your input is not valid! ");
            }
        }
    }

    public void exit() {
        System.out.println("Are you sure? this will exit the game, sign you out and start the app again (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        Boolean validAnswer = false;
        while (!validAnswer) {
            if (answer.equals("yes")) {
                startTheApp();
                validAnswer = true;
            }
            if (answer.equals("no"))
                validAnswer = true;
            else
                System.out.println("Your input is not valid! Enter yes or no : ");
        }
    }
    public void exit_all () {
        System.exit(0);
    }

    public void goToCardMenus(){
        System.out.println("which *Menu*  do you want to go(collections/store)?" + "\n"+ "(exit/exit_all/help)");
        Scanner scanner = new Scanner(System.in);
        String MenuName = scanner.nextLine();
        Boolean isValidName = false;
        while (!isValidName) {
            switch (MenuName) {
                case "collections":
                    isValidName = true;
                    goToCollectionsMenu();
                    break;
                case "store":
                    isValidName = true;
                    goToStoreMenu();
                    break;
                case "exit":
                    exit();
                    break;
                case "exit_all":
                    exit_all();
                    break;
                case "help":
                    help();
                    break;
                default:{
                    System.out.println("invalid Menu name! Try again..");
                }
            }
        }
    }
    //TODO add a quick menu wich uses all the methods instantly without guiding so much
    public void help(){
        System.out.println("collections : this will show the game collection and your collection  of cards and heroes in game ");
        System.out.println("store : a place to buy or sell cards!!");
        System.out.println("exit : this will exit the game, sign you out and start the app again ");
        System.out.println("exit_all : this will exit you from the app");
        System.out.println("deleteThePlayer : this wil delete your account");
    }
}
