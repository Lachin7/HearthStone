package Player;

import Cards.card;
import Exceptions.PlayerAlreadyExistsException;
import Exceptions.PlayerNotFoundException;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

import static JSON.jsonForPlayers.jsonForPlayers.*;

public class Player {
/** defining fields in Player class */
    private String PlayerName;
    private String PlayerPassword;
    private int PlayerCoins;
    public ArrayList<card> ALLPlayersCards = new ArrayList<>();
    /** defining getters and setters for the fields  */
    public String getPlayerName() {
        return PlayerName;
    }
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }
    public String getPlayerPassword() {
        return PlayerPassword;
    }
    public void setPlayerPassword(String playerPassword) {
        PlayerPassword = playerPassword;
    }
    public int getPlayerCoins() {
        return PlayerCoins;
    }
    public void setPlayerCoins(int playerCoins) {
        PlayerCoins = playerCoins;
    }

    Boolean IsSignedin = false;
    Scanner scanner = new Scanner(System.in);

    public void Signup(){
        boolean flagName = false;
        boolean flagPass = false;

        while (!flagName) {
            try {
                System.out.println("Creat your user name: ");
                PlayerName = scanner.nextLine();

                for (int i = 0; i < PlayersJList.size() ; i++) {
                    if(((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerName") == PlayerName ){
                        throw new PlayerAlreadyExistsException() ;
                    }
                }
                flagName = true;
            }
            catch (PlayerAlreadyExistsException e){
                System.out.println("Sorry this name is taken, Try something else..");
            }
        }
        while (!flagPass) {
            try {
                System.out.println("Creat your password: ");
                PlayerPassword = scanner.nextLine();
                //check if players password is legal
                flagPass = true;
            } catch (Exception e2) {
                System.out.println("Password should be beetwin 8-16 characters, Try again..");
            }
        }
        /** mkiang a json file for this player */
        this.setPlayerCoins(50);
        jsonTOfile_player(this);
        IsSignedin = true;
        System.out.println("you are signed up successfully! BEGIN YOUR JOURNEY IN HEARTH STONE!!");
    }

    public void Signin(){
        boolean flagName = false;
        boolean flagPass = false;
        String CorrespondingPassword="";

        while (!flagName){
            try {
                System.out.println("Enter your user name: ");
                PlayerName = scanner.nextLine();
                /**check if players name exists ...*/
                boolean theNameExists = false;
                for (int i = 0; i < PlayersJList.size() ; i++) {
                    if((String)((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerName") == PlayerName ){
                        theNameExists = true;
                        /** also getting its password to check later in password part */
                        CorrespondingPassword =(String)((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerPassword");
                        break;
                    }
                }
                if(theNameExists==false){
                    throw new PlayerNotFoundException();
                }
                flagName = true;
            }
            catch (PlayerNotFoundException e1){
                System.out.println("There isn't an account in this name , Try again..");
            }
        }
        while (!flagPass){
            try {
                System.out.println("Enter your password: ");
                PlayerPassword = scanner.nextLine();
                /**check if players password is correct for the corresponding name ...*/
                if (PlayerPassword != CorrespondingPassword){
                    throw new PlayerNotFoundException();
                }
                flagPass = true;
            }
            catch (PlayerNotFoundException e2){
                System.out.println("Wrong password , Try again..");
            }
        }
        jsonFileReader(this);
        IsSignedin = true;
        System.out.println("you are signed in successfully! WELCOME BACK "+PlayerName+" !!");
    }

    public void test(){
        Signup();
    }


    public void Singout(){

    }

    public void deletThePlayer(){
        Scanner scanner = new Scanner(System.in);
        if(this.IsSignedin == true) {
            Boolean isvalid = false;
            while (!isvalid) {
                System.out.println("Enter your Password");
                String pass = scanner.nextLine();
                if (pass == this.PlayerPassword) {
                    isvalid = true;
                    // delte the info for this player
                    System.exit(0);
                } else {
                    System.out.println("Wrong password! ");
                }

            }
        }
        else{
                System.out.println("you have to sign in first");
            }

    }

    public void goToMenues(){
        System.out.println("which Menu do you want to go(collections/store)?");
        Scanner scanner = new Scanner(System.in);
        String MenuName = scanner.nextLine();
        Boolean isValidName = false;

        while (!isValidName) {

            switch (MenuName) {
                case "collections": {
                    isValidName = true;
                    // show all your cards
                    System.out.println();

                    break;
                }
                case "store": {
                    isValidName = true;
                    // all the cards u dony own or have sold
                    break;
                }
                default:{
                    System.out.println("invalid Menu name! Try again..");
                }

            }
        }
    }


}
