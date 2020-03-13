package JSON.jsonForCards;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static JSON.jsonForCards.jsonForCards.convertFileToJsonForCards;

public class jsonForNeutrals {

    public static class jsonTOfile_Neutrals {

        public static void main( String[] args ){


            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo = new JSONObject();
            cardInfo.put("name","Abusive Sergeant");
            cardInfo.put("manaCost", new Integer(1));
            cardInfo.put("type", "MINION");
            cardInfo.put("heroClass","NEUTRAL");
            cardInfo.put("rarity","COMMON");
            cardInfo.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo.put("HP",new Integer(1));
            cardInfo.put("Attack",new Integer(1));

            JSONObject CardObject = new JSONObject();
            CardObject.put("card", cardInfo);

            /** making a json file for Hungry Crab which belongs to Neutral class */

            JSONObject cardInfo2 = new JSONObject();
            cardInfo2.put("name","Hungry Crab");
            cardInfo2.put("manaCost",new Integer(1));
            cardInfo2.put("type", "NEUTRAL");
            cardInfo2.put("heroClass","MINION");
            cardInfo2.put("rarity","EPIC");
            cardInfo2.put("description","Destroy a Murloc and gain +2/+2.");
            cardInfo2.put("HP",new Integer(2));
            cardInfo2.put("Attack",new Integer(1));

            JSONObject CardObject2 = new JSONObject();
            CardObject2.put("card", cardInfo2);

            /** making a json file for Goblin Bomb which belongs to Neutral class */

            JSONObject cardInfo3 = new JSONObject();
            cardInfo3.put("name","Goblin Bomb");
            cardInfo3.put("manaCost",new Integer(1));
            cardInfo3.put("type", "NEUTRAL");
            cardInfo3.put("heroClass","MINION");
            cardInfo3.put("rarity","COMMON");
            cardInfo3.put("description","Deal 2 damage to the enemy hero.");
            cardInfo3.put("HP",new Integer(2));
            cardInfo3.put("Attack",new Integer(0));

            JSONObject CardObject3 = new JSONObject();
            CardObject3.put("card", cardInfo3);

            /** making a json file for Beaming Sidekick which belongs to Neutral class */

            JSONObject cardInfo4 = new JSONObject();
            cardInfo4.put("name","Beaming Sidekick");
            cardInfo4.put("manaCost", new Integer(1));
            cardInfo4.put("type", "MINION");
            cardInfo4.put("heroClass","NEUTRAL");
            cardInfo4.put("rarity","COMMON");
            cardInfo4.put("description","Give a friendly minion +2 Health.");
            cardInfo4.put("HP",new Integer(2));
            cardInfo4.put("Attack",new Integer(1));

            JSONObject CardObject4 = new JSONObject();
            CardObject4.put("card", cardInfo4);

            /** making a json file for Lost Spirit which belongs to Neutral class */

            JSONObject cardInfo5 = new JSONObject();
            cardInfo5.put("name","Lost Spirit");
            cardInfo5.put("manaCost", new Integer(2));
            cardInfo5.put("type", "MINION");
            cardInfo5.put("heroClass","NEUTRAL");
            cardInfo5.put("rarity","COMMON");
            cardInfo5.put("description","Deathrattle: Give your minions +1 Attack.");
            cardInfo5.put("HP",new Integer(1));
            cardInfo5.put("Attack",new Integer(1));

            JSONObject CardObject5 = new JSONObject();
            CardObject5.put("card", cardInfo5);

            /** making a json file for Magma Rager which belongs to Neutral class */

            JSONObject cardInfo6 = new JSONObject();
            cardInfo6.put("name","Magma Rager");
            cardInfo6.put("manaCost", new Integer(3));
            cardInfo6.put("type", "MINION");
            cardInfo6.put("heroClass","NEUTRAL");
            cardInfo6.put("rarity","FREE");
            cardInfo6.put("description","-");
            cardInfo6.put("HP",new Integer(1));
            cardInfo6.put("Attack",new Integer(5));

            JSONObject CardObject6 = new JSONObject();
            CardObject6.put("card", cardInfo6);

            /** making a json file for Murloc Raider which belongs to Neutral class */

            JSONObject cardInfo7 = new JSONObject();
            cardInfo7.put("name","Murloc Raider");
            cardInfo7.put("manaCost", new Integer(1));
            cardInfo7.put("type", "MINION");
            cardInfo7.put("heroClass","NEUTRAL");
            cardInfo7.put("rarity","COMMON");
            cardInfo7.put("description","-");
            cardInfo7.put("HP",new Integer(1));
            cardInfo7.put("Attack",new Integer(2));

            JSONObject CardObject7 = new JSONObject();
            CardObject7.put("card", cardInfo7);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo8 = new JSONObject();
            cardInfo8.put("name","Abusive Sergeant");
            cardInfo8.put("manaCost", new Integer(1));
            cardInfo8.put("type", "MINION");
            cardInfo8.put("heroClass","NEUTRAL");
            cardInfo8.put("rarity","COMMON");
            cardInfo8.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo8.put("HP",new Integer(1));
            cardInfo8.put("Attack",new Integer(1));

            JSONObject CardObject8 = new JSONObject();
            CardObject8.put("card", cardInfo8);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo9 = new JSONObject();
            cardInfo9.put("name","Abusive Sergeant");
            cardInfo9.put("manaCost", new Integer(1));
            cardInfo9.put("type", "MINION");
            cardInfo9.put("heroClass","NEUTRAL");
            cardInfo9.put("rarity","COMMON");
            cardInfo9.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo9.put("HP",new Integer(1));
            cardInfo9.put("Attack",new Integer(1));

            JSONObject CardObject9 = new JSONObject();
            CardObject9.put("card", cardInfo9);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo10 = new JSONObject();
            cardInfo10.put("name","Abusive Sergeant");
            cardInfo10.put("manaCost", new Integer(1));
            cardInfo10.put("type", "MINION");
            cardInfo10.put("heroClass","NEUTRAL");
            cardInfo10.put("rarity","COMMON");
            cardInfo10.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo10.put("HP",new Integer(1));
            cardInfo10.put("Attack",new Integer(1));

            JSONObject CardObject10 = new JSONObject();
            CardObject10.put("card", cardInfo10);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo11 = new JSONObject();
            cardInfo11.put("name","Abusive Sergeant");
            cardInfo11.put("manaCost", new Integer(1));
            cardInfo11.put("type", "MINION");
            cardInfo11.put("heroClass","NEUTRAL");
            cardInfo11.put("rarity","COMMON");
            cardInfo11.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo11.put("HP",new Integer(1));
            cardInfo11.put("Attack",new Integer(1));

            JSONObject CardObject11 = new JSONObject();
            CardObject11.put("card", cardInfo11);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo12 = new JSONObject();
            cardInfo12.put("name","Abusive Sergeant");
            cardInfo12.put("manaCost", new Integer(1));
            cardInfo12.put("type", "MINION");
            cardInfo12.put("heroClass","NEUTRAL");
            cardInfo12.put("rarity","COMMON");
            cardInfo12.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo12.put("HP",new Integer(1));
            cardInfo12.put("Attack",new Integer(1));

            JSONObject CardObject12 = new JSONObject();
            CardObject12.put("card", cardInfo12);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo13 = new JSONObject();
            cardInfo13.put("name","Abusive Sergeant");
            cardInfo13.put("manaCost", new Integer(1));
            cardInfo13.put("type", "MINION");
            cardInfo13.put("heroClass","NEUTRAL");
            cardInfo13.put("rarity","COMMON");
            cardInfo13.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo13.put("HP",new Integer(1));
            cardInfo13.put("Attack",new Integer(1));

            JSONObject CardObject13 = new JSONObject();
            CardObject13.put("card", cardInfo13);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo14 = new JSONObject();
            cardInfo14.put("name","Abusive Sergeant");
            cardInfo14.put("manaCost", new Integer(1));
            cardInfo14.put("type", "MINION");
            cardInfo14.put("heroClass","NEUTRAL");
            cardInfo14.put("rarity","COMMON");
            cardInfo14.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo14.put("HP",new Integer(1));
            cardInfo14.put("Attack",new Integer(1));

            JSONObject CardObject14 = new JSONObject();
            CardObject14.put("card", cardInfo14);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo15 = new JSONObject();
            cardInfo15.put("name","Abusive Sergeant");
            cardInfo15.put("manaCost", new Integer(1));
            cardInfo15.put("type", "MINION");
            cardInfo15.put("heroClass","NEUTRAL");
            cardInfo15.put("rarity","COMMON");
            cardInfo15.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo15.put("HP",new Integer(1));
            cardInfo15.put("Attack",new Integer(1));

            JSONObject CardObject15 = new JSONObject();
            CardObject15.put("card", cardInfo15);

            /** making a json file for Abusive Sergeant  which belongs to Neutral class */

            JSONObject cardInfo16 = new JSONObject();
            cardInfo16.put("name","Abusive Sergeant");
            cardInfo16.put("manaCost", new Integer(1));
            cardInfo16.put("type", "MINION");
            cardInfo16.put("heroClass","NEUTRAL");
            cardInfo16.put("rarity","COMMON");
            cardInfo16.put("description","Battlecry: Give a minion +2 Attack this turn.");
            cardInfo16.put("HP",new Integer(1));
            cardInfo16.put("Attack",new Integer(1));

            JSONObject CardObject16 = new JSONObject();
            CardObject16.put("card", cardInfo16);


            /** making an arraylist to have all cards in Neutral class */
            JSONArray RougeJCardList = new JSONArray();
            RougeJCardList.add(CardObject);
            RougeJCardList.add(CardObject2);

            //Write JSON file
            try (FileWriter file = new FileWriter("NuetralCards.json")) {
                file.write(RougeJCardList.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static class fileTOjson_Neutrals {
        public static void main(String[] args) {
            convertFileToJsonForCards("NeutralCards");
        }
    }
}
