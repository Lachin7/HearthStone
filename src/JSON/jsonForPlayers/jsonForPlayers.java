package JSON.jsonForPlayers;

import Player.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class jsonForPlayers {

    public static void jsonTOfile_player(Player player){

        JSONObject playerInfo = new JSONObject();
        playerInfo.put("PlayerName",""+player.getPlayerName());
        playerInfo.put("PlayerPassword",""+player.getPlayerPassword());
        playerInfo.put("PlayerCoins", player.getPlayerCoins());
        playerInfo.put("ALLPlayersCards","" /** TODO */);

        JSONObject PlayerObject = new JSONObject();
        PlayerObject.put("Player", playerInfo);
        PlayersJList.add(PlayerObject);

        //Write JSON file
        try (FileWriter file = new FileWriter(player.getPlayerName()+".json")) {
            file.write(PlayerObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player jsonFileReader(Player player){

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(player.getPlayerName()+".json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject playerInfo = (JSONObject) obj;
            player.setPlayerName((String) playerInfo.get("PlayerName"));
            player.setPlayerName((String) playerInfo.get("PlayerPassword"));
            player.setPlayerName((String) playerInfo.get("PlayerCoins"));
            player.ALLPlayersCards = (ArrayList) playerInfo.get("ALLPlayersCards");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return player;
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

    /** making an arraylist to have all players and save them in another file */
    public static JSONArray PlayersJList = new JSONArray();
    public static void main(String[] args) {
        //Write JSON file
        try (FileWriter file = new FileWriter("Players.json")) {
            file.write(PlayersJList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
