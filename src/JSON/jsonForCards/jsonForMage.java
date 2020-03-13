package JSON.jsonForCards;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static JSON.jsonForCards.jsonForCards.convertFileToJsonForCards;


public class jsonForMage {

    public static class jsonTOfile_Mage {
        public static void main( String[] args ){

            /** making a json file for PolyMorph which belongs to Mage class */

            JSONObject cardInfo = new JSONObject();
            cardInfo.put("name","Polymorph");
            cardInfo.put("manaCost", new Integer(4));
            cardInfo.put("type", "SPELL");
            cardInfo.put("heroClass","MAGE");
            cardInfo.put("rarity","RARE");
            cardInfo.put("description","Transform minion in to a 1/1 sheep.");
            // objMapper.put("spell",)
            JSONObject CardObject = new JSONObject();
            CardObject.put("card", cardInfo);

            /** making a json file for Rolling Fireball which belongs to Mage class */

            JSONObject cardInfo2 = new JSONObject();
            cardInfo2.put("name","RollingFireball");
            cardInfo2.put("manaCost",new Integer(5));
            cardInfo2.put("type", "SPELL");
            cardInfo2.put("heroClass","MAGE");
            cardInfo2.put("rarity","EPIC");
            cardInfo2.put("description","Deal 8 damage to a minion. Any excess damage continues to the left or right.");
            // objMapper.put("spell",)
            JSONObject CardObject2 = new JSONObject();
            CardObject2.put("card", cardInfo2);

            /** making an arraylist to have all cards in Mage class */
            JSONArray MageCardList = new JSONArray();
            MageCardList.add(CardObject);
            MageCardList.add(CardObject2);

            //Write JSON file
            try (FileWriter file = new FileWriter("MageCards.json")) {
                file.write(MageCardList.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class fileTOjson_Mage {
        public static void main(String[] args) {
            convertFileToJsonForCards("MageCards");
        }
    }

}
