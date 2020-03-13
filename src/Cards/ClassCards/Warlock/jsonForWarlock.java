package Cards.ClassCards.Warlock;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static JSON.fileTOjson.fileTOjson.convertFileToJsonForCards;

public class jsonForWarlock {

    public static class jsonTOfile_Warlock {

        public static void main( String[] args ){

            /** making a json file for Dreadscale which belongs to Warlock class */

            JSONObject cardInfo = new JSONObject();
            cardInfo.put("name","Dreadscale");
            cardInfo.put("manaCost", new Integer(3));
            cardInfo.put("type", "MINION");
            cardInfo.put("heroClass","WARLOCK");
            cardInfo.put("rarity","LEGENDARY");
            cardInfo.put("description","At the end of your turn deal 1 damage to all other minions.");
            cardInfo.put("HP",new Integer(2));
            cardInfo.put("Attack",new Integer(4));
            // objMapper.put("spell",)
            JSONObject CardObject = new JSONObject();
            CardObject.put("card", cardInfo);

            /** making a json file for Ratcatcher which belongs to Mage class */

            JSONObject cardInfo2 = new JSONObject();
            cardInfo2.put("name","Ratcatcher");
            cardInfo2.put("manaCost",new Integer(3));
            cardInfo2.put("type", "MINION");
            cardInfo2.put("heroClass","WARLOCK");
            cardInfo2.put("rarity","EPIC");
            cardInfo2.put("description","Rush   Battlecry: Destroy a friendly minion and gain its Attack and Health.");
            cardInfo2.put("HP",new Integer(2));
            cardInfo2.put("Attack",new Integer(2));

            JSONObject CardObject2 = new JSONObject();
            CardObject2.put("card", cardInfo2);

            /** making an arraylist to have all cards in Rouge class */
            JSONArray RougeJCardList = new JSONArray();
            RougeJCardList.add(CardObject);
            RougeJCardList.add(CardObject2);

            //Write JSON file
            try (FileWriter file = new FileWriter("WarlockCards.json")) {
                file.write(RougeJCardList.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static class fileTOjson_Warlock {
        public static void main(String[] args) {
            convertFileToJsonForCards("WarlockCards");
        }
    }
}
