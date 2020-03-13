package Player;

import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class jsonForPlayers {

    /** making an arraylist to have all players */
    static JSONArray PlayersJList = new JSONArray();

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
