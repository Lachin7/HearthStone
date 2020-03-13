package JSON.fileTOjson;

import Player.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileTOjson {

    public static void convertFileToJsonForCards(String fileName){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName+".json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray Jlist = (JSONArray) obj;
            System.out.println(Jlist);

            //Iterate over MageCards array
            for(int i =0 ; i< Jlist.size(); i++){
                parseCardObject((JSONObject)Jlist.get(i));
            }
            // Jlist.forEach(card -> parseCardObject((JSONObject) card));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void convertFileToJsonForPlayers(String fileName , Player playerSignedIn){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName+".json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray Jlist = (JSONArray) obj;
            System.out.println(Jlist);

            //Iterate over MageCards array
            for(int i =0 ; i< Jlist.size(); i++){
                parsePlayerObject((JSONObject)Jlist.get(i), playerSignedIn);
            }

            // Jlist.forEach(card -> parseCardObject((JSONObject) card));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseCardObject(JSONObject card){

        //Get card object within list
        JSONObject cardObject = (JSONObject) card.get("card");

        //Get card first name
        String name = (String) cardObject.get("name");
        System.out.println(name);

        //Get card mana cost
        String manaCost = (String) cardObject.get("manaCost");
        System.out.println(manaCost);

        //Get card type
        String type = (String) cardObject.get("type");
        System.out.println(type);

        //Get card first heroClass
        String heroClass = (String) cardObject.get("heroClass");
        System.out.println(heroClass);

        //Get card  rarity
        String rarity = (String) cardObject.get("rarity");
        System.out.println(rarity);

        //Get card description
        String description = (String) cardObject.get("description");
        System.out.println(description + "\n");


    }
    public static void parsePlayerObject(JSONObject player, Player playerSignedIn) {

        //Get card object within list
        JSONObject cardObject = (JSONObject) player.get("Player");

        if ((String) cardObject.get("PlayerName") == playerSignedIn.getPlayerName() &&
                (String) cardObject.get("PlayerPassword") == playerSignedIn.getPlayerPassword()) {

            //Get card PlayerName
            String PlayerName = (String) cardObject.get("PlayerName");
            System.out.println(PlayerName);

            //Get card PlayerPassword
            String PlayerPassword = (String) cardObject.get("PlayerPassword");
            System.out.println(PlayerPassword);

            //Get card PlayerCoins
            String PlayerCoins = (String) cardObject.get("PlayerCoins");
            System.out.println(PlayerCoins);

            //Get card PlayersCards
            String PlayersCards = (String) cardObject.get("PlayersCards");
            System.out.println(PlayersCards);

        }

    }

}
