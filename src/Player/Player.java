package Player;
import cliAndMenus.gameCLI;
import Cards.card;
import Exceptions.*;
import Heroes.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;

import static Cards.card.*;
import static JSON.jsonForCards.jsonForCards.creatCardFromjson;
import static JSON.jsonForPlayers.jsonForPlayers.*;

public class Player {

/** defining fields in Player class */
    @Expose private String PlayerName;
    @Expose private String PlayerPassword;
    @Expose private long PlayerCoins ;
    @Expose private Hero PlayersChoosedHero;
    @Expose private  ArrayList<card> ALLPlayersCards = new ArrayList<>();
    @Expose private ArrayList<card> PlayersDeckCards = new ArrayList<>();
    @Expose private ArrayList<Hero> PlayersUnlockedHeroes = new ArrayList<>();
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
    public long getPlayerCoins() {
        return PlayerCoins;
    }
    public void setPlayerCoins(long playerCoins) {
        PlayerCoins = playerCoins;
    }
    public Hero getPlayersChoosedHero() {
        return PlayersChoosedHero;
    }
    public void setPlayersChoosedHero(Hero playersChoosedHero) {
        PlayersChoosedHero = playersChoosedHero;
    }
//    public ArrayList<card> getPlayersDeckCards() {
//        return PlayersDeckCards;
//    }
//    public void setPlayersDeckCards(ArrayList<card> playersDeckCards) {
//        PlayersDeckCards = playersDeckCards;
//    }
    public ArrayList<card> getALLPlayersCards() {
        return ALLPlayersCards;
    }
    public void setALLPlayersCards(ArrayList<card> ALLPlayersCards) {
        this.ALLPlayersCards = ALLPlayersCards;
    }


    Boolean IsSignedin = false;
     public Mage PlayersMage = new Mage(); public  Rogue PlayersRogue = new Rogue(); public  Warlock PlayersWarlock = new Warlock();

//    public ArrayList<card> getMageDeckCards() {
//        return WarlockDeckCards;
//    }
//    public void setMageDeckCards(ArrayList<card> warlockDeckCards) {
//        WarlockDeckCards = warlockDeckCards;
//    }

    //    public ArrayList<card> getMageDeckCards() {
//        return RogueDeckCards;
//    }
//    public void setMageDeckCards(ArrayList<card> rogueDeckCards) {
//        RogueDeckCards = rogueDeckCards;
//    }
//    private long PlayersManaInCurrentTurn ;
//    public long getPlayersManaInCurrentTurn() {
//        return PlayersManaInCurrentTurn;
//    }
//    public void setPlayersManaInCurrentTurn(long playersManaInCurrentTurn) {
//        PlayersManaInCurrentTurn = playersManaInCurrentTurn;
//    }
    Scanner scanner = new Scanner(System.in);
 //  public static  Player enemyPlayer = new Player();
//    public ArrayList<card> getPlayersBoardCards() {
//        return PlayersBoardCards;
//    }
//
//    public void setPlayersBoardCards(ArrayList<card> playersBoardCards) {
//        PlayersBoardCards = playersBoardCards;
//    }
//   private ArrayList<card> PlayersBoardCards = new ArrayList<>();


//    public Player(/**String playerName,String playerPassword , long playerCoins, Hero playersChoosedHero, ArrayList ALLPlayersCards, ArrayList playersDeckCards*/) {
//        this.PlayerName = PlayerName;
//        this.PlayerPassword = PlayerPassword;
//        this.PlayerCoins = PlayerCoins;
//        this.PlayersChoosedHero = PlayersChoosedHero;
//        this.ALLPlayersCards = ALLPlayersCards;
//        this.PlayersDeckCards = PlayersDeckCards;
//    }

    public void Signup() throws IOException {
        System.out.println("*** so let's sign up :) ***");
        boolean flagName = false;
        boolean flagPass = false;

        while (!flagName) {
            System.out.println("Creat your user name: ");
            this.setPlayerName(scanner.nextLine());
            if(getPlayerFiles(PlayerName)==null){
                flagName = true;
            }
            else {
                System.out.println("Sorry this name is taken, Try something else..");
            }
//            try {
//                JSONParser jsonParser = new JSONParser();
//                FileReader reader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForPlayers/jsonFilesForPlayers/ALLPlayers.json");
//                    Object obj = jsonParser.parse(reader);
//                    JSONArray PlayersJList = (JSONArray) obj;
//                for (int i = 0; i <PlayersJList.size() ; i++) {
//                    if(((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerName").equals(this.getPlayerName()) ){
//                        throw new PlayerAlreadyExistsException() ;
//                    }
//                }

//            }
//            catch (PlayerAlreadyExistsException | FileNotFoundException e){
//                System.out.println("Sorry this name is taken, Try something else..");
//            } catch (ParseException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        while (!flagPass) {
            try {
                System.out.println("Creat your password: ");
                this.setPlayerPassword(scanner.nextLine());
                //check if players password is legal
                flagPass = true;
            } catch (Exception e2) {
                System.out.println("Password should be beetwin 8-16 characters, Try again..");
            }
        }
        /** mkiang a json file for this player */
        this.setPlayerCoins(50);
        this.setPlayersChoosedHero(PlayersMage);
        PlayersMage.setHeroDeckCards(new ArrayList<card>(Arrays.asList(creatCardFromjson("Polymorph"),creatCardFromjson("RollingFireball"),creatCardFromjson("MurlocRaider"),creatCardFromjson("MalygossExplosion"),creatCardFromjson("MalygossNova"),creatCardFromjson("Backstab"),creatCardFromjson("GoblinBomb"),creatCardFromjson("LostSpirit"),creatCardFromjson("SerratedTooth"),creatCardFromjson("MagmaRager"))));
        //MageDeckCards = (new ArrayList<card>(Arrays.asList(creatCardFromjson("Polymorph"),creatCardFromjson("RollingFireball"),creatCardFromjson("MurlocRaider"),creatCardFromjson("MalygossExplosion"),creatCardFromjson("MalygossNova"),creatCardFromjson("Backstab"),creatCardFromjson("GoblinBomb"),creatCardFromjson("LostSpirit"),creatCardFromjson("SerratedTooth"),creatCardFromjson("MagmaRager"))));
        this.PlayersDeckCards=PlayersMage.getHeroDeckCards();
        this.setALLPlayersCards(PlayersMage.getHeroDeckCards());
//        this.getPlayersDeckCards().add(creatCardFromjson("Polymorph"));this.getPlayersDeckCards().add(creatCardFromjson("RollingFireball"));this.getPlayersDeckCards().add(creatCardFromjson("MurlocRaider"));this.getPlayersDeckCards().add(creatCardFromjson("MalygossExplosion"));this.getPlayersDeckCards().add(creatCardFromjson("MalygossNova"));this.getPlayersDeckCards().add(creatCardFromjson("Backstab"));this.getPlayersDeckCards().add(creatCardFromjson("GoblinBomb"));this.getPlayersDeckCards().add(creatCardFromjson("LostSpirit"));this.getPlayersDeckCards().add(creatCardFromjson("SerratedTooth"));this.getPlayersDeckCards().add(creatCardFromjson("MagmaRager"));this.getPlayersDeckCards().add(creatCardFromjson("MalygossFrostbolt"));
//        this.ALLPlayersCards.add(creatCardFromjson("Polymorph"));this.ALLPlayersCards.add(creatCardFromjson("RollingFireball"));this.ALLPlayersCards.add(creatCardFromjson("MurlocRaider"));this.ALLPlayersCards.add(creatCardFromjson("MalygossExplosion"));this.ALLPlayersCards.add(creatCardFromjson("MalygossNova"));this.ALLPlayersCards.add(creatCardFromjson("Backstab"));this.ALLPlayersCards.add(creatCardFromjson("GoblinBomb"));this.ALLPlayersCards.add(creatCardFromjson("LostSpirit"));this.ALLPlayersCards.add(creatCardFromjson("SerratedTooth"));this.ALLPlayersCards.add(creatCardFromjson("MagmaRager"));this.ALLPlayersCards.add(creatCardFromjson("MalygossFrostbolt"));

        jsonTofilePlayer(this);
        gameCLI.getInstance().setCurrentPlayer(this);
        IsSignedin = true;
        System.out.println("you are signed up successfully! BEGIN YOUR JOURNEY IN HEARTH STONE!!");
    }

    public void Signin() throws IOException {
        System.out.println("*** so let's sign in :) ***");
        boolean flagName = false;
        boolean flagPass = false;
        String CorrespondingPassword="";
        while (!flagName){
          //  try {
                System.out.println("Enter your user name: ");
                PlayerName = scanner.nextLine();
                /**check if players name exists ...*/
                if(getPlayerFiles(getPlayerName())==null){
                    System.out.println("There isn't an account in this name , Try again..");
                }
                else{
                    flagName = true;
                    CorrespondingPassword =  jsonFileReader(getPlayerName()).getPlayerPassword();
                }

//                boolean theNameExists = true;
//
//                JSONParser jsonParser = new JSONParser();
//                FileReader reader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForPlayers/jsonFilesForPlayers/ALLPlayers.json");
//                Object obj = jsonParser.parse(reader);
//                JSONArray PlayersJList = (JSONArray) obj;
//                for (int i = 0; i < PlayersJList.size() ; i++) {
//                    if(((String)((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerName")).equals(PlayerName) ){
//                        theNameExists = false;
//                        /** also getting its password to check later in password part */
//                        CorrespondingPassword =(String)((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerPassword");
//                        reader.close();
//                        break;
//                    }
//                }
//                if(theNameExists==true){
//                    throw new PlayerNotFoundException();
//                }
//                flagName = true;
//            }
//            catch (PlayerNotFoundException | FileNotFoundException e1){
//                System.out.println("There isn't an account in this name , Try again..");
//            } catch (ParseException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        while (!flagPass){
            System.out.println("Enter your Password: ");
                PlayerPassword = scanner.nextLine();
                /**check if players password is correct for the corresponding name ...*/
                if (!PlayerPassword.equals(CorrespondingPassword)) {
                    System.out.println("Wrong password , Try again..");
                }
                else {
                    flagPass = true;
                }
        }
        IsSignedin = true;
        gameCLI.getInstance().setCurrentPlayer(jsonFileReader(this.getPlayerName()));
        System.out.println("you are signed in successfully! WELCOME BACK "+getPlayerName()+" !!");
    }

    public void deleteThePlayer() throws IOException {
        if(this.IsSignedin == true) {
            Boolean isvalid = false;
            while (!isvalid) {
                System.out.println("If you are sure of DELETING your account, enter your Password : ");
                String pass = scanner.nextLine();
                if (pass == this.PlayerPassword) {
                    getPlayerFiles(PlayerName).deleteOnExit();
                    System.exit(0);
                }
            }

//        Scanner scanner = new Scanner(System.in);
//        if(this.IsSignedin == true) {
//            Boolean isvalid = false;
//            while (!isvalid) {
//                System.out.println("If you are sure of DELETING your account, enter your Password : ");
//                String pass = scanner.nextLine();
//                if (pass == this.PlayerPassword) {
//                    isvalid = true;
//                    this.setPlayerName("deleted account");
//                    this.setPlayerPassword("-");
//                    this.setPlayerCoins(0);
//                    this.ALLPlayersCards = null;
//                    this.PlayersChoosedHero=null;
//                    this.PlayersDeckCards=null;
//                     jsonTofilePlayer(this);
//                    System.exit(0);
//                } else {
//                    System.out.println("Wrong password! ");
//                }
//            }
        }
        else{
                System.out.println("you have to sign in first");
            }
    }

//    public static ArrayList<card> getPlayersMageCards(){
//        ArrayList<card> arrayList = new ArrayList<>();
//        for (card card : ALLPlayersCards) {
//            if((Hero)card.getHeroClass()== Mage.getInstance())
//                arrayList.add(card);
//        }
//        return arrayList;
//    }
//    public static ArrayList<card> getPlayersRougeCards(){
//        ArrayList<card> arrayList = new ArrayList<>();
//        for (card card : ALLPlayersCards) {
//            if((Hero)card.getHeroClass()== Rogue.getInstance())
//                arrayList.add(card);
//        }
//        return arrayList;
//    }
//    public static ArrayList<card> getPlayersWarlockCards(){
//        ArrayList<card> arrayList = new ArrayList<>();
//        for (card card : ALLPlayersCards) {
//            if((Hero)card.getHeroClass()== Mage.getInstance())
//                arrayList.add(card);
//        }
//        return arrayList;
//    }
    public static void main(String[] args) throws IOException, ParseException {

    }

}
