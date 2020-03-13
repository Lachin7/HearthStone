package Player;

import Cards.card;
import Exceptions.PlayerAlreadyExistsException;
import Exceptions.PlayerNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Player.jsonForPlayers.PlayersJList;

public class Player {

    private String PlayerName;
    public String getPlayerName() {
        return PlayerName;
    }
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    private String PlayerPassword;
    public String getPlayerPassword() {
        return PlayerPassword;
    }
    public void setPlayerPassword(String playerPassword) {
        PlayerPassword = playerPassword;
    }

    private int PlayerCoins = 50;
    public int getPlayerCoins() {
        return PlayerCoins;
    }
    public void setPlayerCoins(int playerCoins) {
        PlayerCoins = playerCoins;
    }

    ArrayList<card> PlayersCards = new ArrayList<>();

    Boolean IsSignedin = false;
    Scanner scanner = new Scanner(System.in);

    public void Signup()throws PlayerAlreadyExistsException{
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
        while (!flagPass){
            try {
                System.out.println("Creat your password: ");
                PlayerPassword = scanner.nextLine();
                //check if players password is legal
                flagPass = true;
            }
            catch (Exception e2){
                System.out.println("Password should be beetwin 8-16 characters, Try again..");
            }
        }
        IsSignedin = true;

        /** mkiang a json file for this player */
        JSONObject playerInfo = new JSONObject();
        playerInfo.put("PlayerName",""+PlayerName);
        playerInfo.put("PlayerPassword",""+PlayerPassword);
        playerInfo.put("PlayerCoins", new Integer(50));
        playerInfo.put("PlayersCards","" /** TODO */);

        JSONObject PlayerObject = new JSONObject();
        PlayerObject.put("Player", playerInfo);

        PlayersJList.add(PlayerObject);

    }

    public void Signin() throws PlayerNotFoundException{
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
                //check if players
                /**check if players password is correct for the corresponding name ...*/
                boolean thePasswordExists = false;
                if (PlayerPassword != CorrespondingPassword){
                    throw new PlayerNotFoundException();
                }
                flagPass = true;
            }
            catch (PlayerNotFoundException e2){
                System.out.println("Wrong password , Try again..");
            }
        }
        IsSignedin = true;


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
