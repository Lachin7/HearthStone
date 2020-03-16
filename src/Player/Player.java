package Player;
import cliAndMenus.gameCLI;
import Cards.card;
import Exceptions.*;
import Heroes.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;
import static JSON.jsonForCards.jsonForCards.creatCard;
import static JSON.jsonForPlayers.jsonForPlayers.*;

public class Player {
/** defining fields in Player class */
    private String PlayerName;
    private String PlayerPassword;
    private long PlayerCoins;
    private Hero PlayersChoosedHero;
    private static ArrayList<card> ALLPlayersCards = new ArrayList<>();
    private ArrayList<card> PlayersDeckCards = new ArrayList<>();
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
    public ArrayList<card> getPlayersDeckCards() {
        return PlayersDeckCards;
    }
    public void setPlayersDeckCards(ArrayList<card> playersDeckCards) {
        PlayersDeckCards = playersDeckCards;
    }
    public ArrayList<card> getALLPlayersCards() {
        return ALLPlayersCards;
    }
    public void setALLPlayersCards(ArrayList<card> ALLPlayersCards) {
        this.ALLPlayersCards = ALLPlayersCards;
    }

    Boolean IsSignedin = false;
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

    public void Signup(){

        boolean flagName = false;
        boolean flagPass = false;

        while (!flagName) {
            System.out.println("Creat your user name: ");
            PlayerName=scanner.nextLine();
            try {
                JSONParser jsonParser = new JSONParser();
                FileReader reader = new FileReader("ALLPlayers.json");
                    Object obj = jsonParser.parse(reader);
                    JSONArray PlayersJList = (JSONArray) obj;
                for (int i = 0; i <PlayersJList.size() ; i++) {
                    if(((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerName").equals(PlayerName) ){
                        throw new PlayerAlreadyExistsException() ;
                    }
                }
              flagName = true;
            }
            catch (PlayerAlreadyExistsException | FileNotFoundException e){
                System.out.println("Sorry this name is taken, Try something else..");
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
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
        this.setPlayersChoosedHero(Mage.getInstance());
        this.PlayersDeckCards.add(creatCard("Polymorph"));this.PlayersDeckCards.add(creatCard("RollingFireball"));this.PlayersDeckCards.add(creatCard("Murloc Raider"));this.PlayersDeckCards.add(creatCard("Malygos's Explosion"));this.PlayersDeckCards.add(creatCard("Malygos's Nova"));this.PlayersDeckCards.add(creatCard("Serrated Tooth"));this.PlayersDeckCards.add(creatCard("Goblin Bomb"));this.PlayersDeckCards.add(creatCard("Lost Spirit"));this.PlayersDeckCards.add(creatCard("Serrated Tooth.json"));this.PlayersDeckCards.add(creatCard("Magma Rager"));this.PlayersDeckCards.add(creatCard("Malygos's Frostbolt"));
        this.ALLPlayersCards.add(creatCard("Polymorph"));this.ALLPlayersCards.add(creatCard("RollingFireball"));this.ALLPlayersCards.add(creatCard("Murloc Raider"));this.ALLPlayersCards.add(creatCard("Malygos's Explosion"));this.ALLPlayersCards.add(creatCard("Malygos's Nova"));this.ALLPlayersCards.add(creatCard("Serrated Tooth"));this.ALLPlayersCards.add(creatCard("Goblin Bomb"));this.ALLPlayersCards.add(creatCard("Lost Spirit"));this.ALLPlayersCards.add(creatCard("Serrated Tooth.json"));this.ALLPlayersCards.add(creatCard("Magma Rager"));this.ALLPlayersCards.add(creatCard("Malygos's Frostbolt"));
        jsonTofilePlayer(this);
        gameCLI.getInstance().setCurrentPlayer(this);
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

                JSONParser jsonParser = new JSONParser();
                FileReader reader = new FileReader("ALLPlayers.json");
                Object obj = jsonParser.parse(reader);
                JSONArray PlayersJList = (JSONArray) obj;
                for (int i = 0; i < PlayersJList.size() ; i++) {
                    if(((String)((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerName")).equals(PlayerName) ){
                        theNameExists = true;
                        /** also getting its password to check later in password part */
                        CorrespondingPassword =(String)((JSONObject)(((JSONObject)(PlayersJList.get(i))).get("Player"))).get("PlayerPassword");
                        reader.close();
                        break;
                    }
                }
                if(theNameExists==false){
                    throw new PlayerNotFoundException();
                }
                flagName = true;
            }
            catch (PlayerNotFoundException | FileNotFoundException e1){
                System.out.println("There isn't an account in this name , Try again..");
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (!flagPass){
            System.out.println("Enter your Password: ");
            try {
                PlayerPassword = scanner.nextLine();
                /**check if players password is correct for the corresponding name ...*/
                if (!PlayerPassword.equals(CorrespondingPassword)){
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
        gameCLI.getInstance().setCurrentPlayer(this);
        System.out.println("you are signed in successfully! WELCOME BACK "+getPlayerName()+" !!");
    }

    public void deleteThePlayer(){
        Scanner scanner = new Scanner(System.in);
        if(this.IsSignedin == true) {
            Boolean isvalid = false;
            while (!isvalid) {
                System.out.println("If you are sure of DELETING your account, enter your Password : ");
                String pass = scanner.nextLine();
                if (pass == this.PlayerPassword) {
                    isvalid = true;
                    this.setPlayerName("deleted account");
                    this.setPlayerPassword("-");
                    this.setPlayerCoins(0);
                    this.ALLPlayersCards = null;
                    this.PlayersChoosedHero=null;
                    this.PlayersDeckCards=null;
                    jsonFileUpdater(this);
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

    public static ArrayList<card> getPlayersMageCards(){
        ArrayList<card> arrayList = new ArrayList<>();
        for (card card : ALLPlayersCards) {
            if((Hero)card.getHeroClass()== Mage.getInstance())
                arrayList.add(card);
        }
        return arrayList;
    }
    public static ArrayList<card> getPlayersRougeCards(){
        ArrayList<card> arrayList = new ArrayList<>();
        for (card card : ALLPlayersCards) {
            if((Hero)card.getHeroClass()== Rogue.getInstance())
                arrayList.add(card);
        }
        return arrayList;
    }
    public static ArrayList<card> getPlayersWarlockCards(){
        ArrayList<card> arrayList = new ArrayList<>();
        for (card card : ALLPlayersCards) {
            if((Hero)card.getHeroClass()== Mage.getInstance())
                arrayList.add(card);
        }
        return arrayList;
    }
    public static void main(String[] args) throws IOException, ParseException {

    }

}
