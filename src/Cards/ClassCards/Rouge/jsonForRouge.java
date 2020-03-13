package Cards.ClassCards.Rouge;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static JSON.fileTOjson.fileTOjson.convertFileToJsonForCards;

public class jsonForRouge {

    public static class jsonTOfile_Rouge {

        public static void main( String[] args ){

            /** making a json file for Friendly Smith which belongs to Rouge class */

            JSONObject cardInfo = new JSONObject();
            cardInfo.put("name","Friendly Smith");
            cardInfo.put("manaCost", new Integer(1));
            cardInfo.put("type", "SPELL");
            cardInfo.put("heroClass","ROUGE");
            cardInfo.put("rarity","COMMON");
            cardInfo.put("description","Discover a weapon from any class. Add it to your Adventure Deck with +2/+2");
            // objMapper.put("spell",)
            JSONObject CardObject = new JSONObject();
            CardObject.put("card", cardInfo);

            /** making a json file for Blink Fox which belongs to Mage class */

            JSONObject cardInfo2 = new JSONObject();
            cardInfo2.put("name","Blink Fox");
            cardInfo2.put("manaCost",new Integer(3));
            cardInfo2.put("type", "SPELL");
            cardInfo2.put("heroClass","ROUGE");
            cardInfo2.put("rarity","COMMON");
            cardInfo2.put("description","Battlecry: Add a random card to your hand (from your opponent's class).");
            cardInfo2.put("HP",new Integer(3));
            cardInfo2.put("Attack",new Integer(3));

            JSONObject CardObject2 = new JSONObject();
            CardObject2.put("card", cardInfo2);

            /** making an arraylist to have all cards in Rouge class */
            JSONArray RougeJCardList = new JSONArray();
            RougeJCardList.add(CardObject);
            RougeJCardList.add(CardObject2);

            //Write JSON file
            try (FileWriter file = new FileWriter("MageCards.json")) {
                file.write(RougeJCardList.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static class fileTOjson_Rouge {
        public static void main(String[] args) {
            convertFileToJsonForCards("RougeCards");
        }
    }
}
