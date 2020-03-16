package JSON.jsonForPlayers;

import Heroes.Hero;
import Player.Player;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.util.ArrayList;

public class jsonForPlayers {

    public static void jsonTofilePlayer(Player player){

        JSONObject playerInfo = new JSONObject();
        playerInfo.put("PlayerName",""+player.getPlayerName());
        playerInfo.put("PlayerPassword",""+player.getPlayerPassword());
        playerInfo.put("PlayerCoins", new Long(50));
        playerInfo.put("PlayersChoosedHero", player.getPlayersChoosedHero());
        playerInfo.put("ALLPlayersCards",player.getALLPlayersCards());
        playerInfo.put("PlayersDeckCards", player.getPlayersDeckCards());

        JSONObject PlayerObject = new JSONObject();
        PlayerObject.put("Player", playerInfo);
        JSONParser jsonParser = new JSONParser();
        JSONArray PlayrsJList = null;

        try(FileReader fileReader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForPlayers/jsonFilesForPlayers/ALLPlayers.json")) {
            Object obj = jsonParser.parse(fileReader);
            PlayrsJList = (JSONArray) obj;
            PlayrsJList.add(PlayerObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForPlayers/jsonFilesForPlayers/ALLPlayers.json")) {
            file.write(PlayrsJList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Write JSON file
        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForPlayers/jsonFilesForPlayers/"+player.getPlayerName()+".json")) {
            file.write(playerInfo.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player jsonFileReader(Player player){

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForPlayers/jsonFilesForPlayers/"+player.getPlayerName()+".json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject playerInfo = (JSONObject) obj;
            player.setPlayerName((String) playerInfo.get("PlayerName"));
            player.setPlayerPassword((String) playerInfo.get("PlayerPassword"));
            player.setPlayerCoins((Long)playerInfo.get("PlayerCoins"));
            player.setPlayersChoosedHero((Hero)playerInfo.get("PlayersChoosedHero"));
            player.setALLPlayersCards((ArrayList)playerInfo.get("ALLPlayersCards"));
            player.setPlayersDeckCards((ArrayList)playerInfo.get("PlayersDeckCards"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return player;
    }

    public static void jsonFileUpdater(Player player) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(player.getPlayerName() + ".json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject playerInfo = (JSONObject) obj;
            playerInfo.replace("PlayerName",""+player.getPlayerName());
            playerInfo.replace("PlayerPassword",""+player.getPlayerPassword());
            playerInfo.replace("PlayerCoins",""+player.getPlayerCoins());
            playerInfo.replace("PlayersChoosedHero", player.getPlayersChoosedHero());
            playerInfo.replace("ALLPlayersCards",player.getALLPlayersCards());
            playerInfo.replace("PlayersDeckCards", player.getPlayersDeckCards());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
      //TODO work here

//        try (FileReader reader = new FileReader( "ALLPlayers.json")) {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
//            JSONObject jsonObject = (JSONObject) obj;
//            JSONObject playerInfo = (JSONObject)jsonObject.get("Player");
//            playerInfo.replace("PlayerName",""+player.getPlayerName());
//            playerInfo.replace("PlayerPassword",""+player.getPlayerPassword());
//            playerInfo.replace("PlayerCoins",""+player.getPlayerCoins());
//            playerInfo.replace("PlayersChoosedHero", player.getPlayersChoosedHero());
//            playerInfo.replace("ALLPlayersCards",player.getALLPlayersCards());
//            playerInfo.replace("PlayersDeckCards", player.getPlayersDeckCards());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
//    public static void convertFileToJsonForPlayers(String fileName , Player playerSignedIn){
//        //JSON parser object to parse read file
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader(fileName+".json")) {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray Jlist = (JSONArray) obj;
//            System.out.println(Jlist);
//
//            //Iterate over MageCards array
//            for(int i =0 ; i< Jlist.size(); i++){
//                parsePlayerObject((JSONObject)Jlist.get(i), playerSignedIn);
//            }
//
//            // Jlist.forEach(card -> parseCardObject((JSONObject) card));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void parsePlayerObject(JSONObject player, Player playerSignedIn) {
//
//        //Get card object within list
//        JSONObject cardObject = (JSONObject) player.get("Player");
//
//        if ((String) cardObject.get("PlayerName") == playerSignedIn.getPlayerName() &&
//                (String) cardObject.get("PlayerPassword") == playerSignedIn.getPlayerPassword()) {
//
//            //Get card PlayerName
//            String PlayerName = (String) cardObject.clone();
//            System.out.println(PlayerName);
//
//            //Get card PlayerPassword
//            String PlayerPassword = (String) cardObject.get("PlayerPassword");
//            System.out.println(PlayerPassword);
//
//            //Get card PlayerCoins
//            String PlayerCoins = (String) cardObject.get("PlayerCoins");
//            System.out.println(PlayerCoins);
//
//            //Get card PlayersCards
//            String PlayersCards = (String) cardObject.get("PlayersCards");
//            System.out.println(PlayersCards);
//
//        }
//
//    }
}
