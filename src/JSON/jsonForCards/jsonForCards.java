package JSON.jsonForCards;

import Cards.*;
import Heroes.HeroClass;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;

public class jsonForCards {

    public static void jsonFileMakerForSpellCards(String name, Long manaCost, String type, String heroClass, String rarity, String description, String Quest, String Reward) {
        JSONObject cardInfo = new JSONObject();
        cardInfo.put("name",name);
        cardInfo.put("manaCost", new Long(manaCost));
        cardInfo.put("type", type);
        cardInfo.put("heroClass",heroClass);
        cardInfo.put("rarity",rarity);
        cardInfo.put("description",description);
        cardInfo.put("Quest",Quest);
        cardInfo.put("Reward",Reward);
        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/"+ name +".json")) {
            file.write(cardInfo.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject CardObject = new JSONObject();
        CardObject.put("SpellCard", cardInfo);
        JSONParser jsonParser = new JSONParser();
        JSONArray CardsJList = null;
        try(FileReader fileReader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
            Object obj = jsonParser.parse(fileReader);
            CardsJList = (JSONArray) obj;
            CardsJList.add(CardObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
            file.write(CardsJList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void jsonFileMakerForMinionCards(String name, Long manaCost, String type, String heroClass, String rarity, String description, Long HP, Long Attack) {
        JSONObject cardInfo = new JSONObject();
        cardInfo.put("name",name);
        cardInfo.put("manaCost", new Long(manaCost));
        cardInfo.put("type", type);
        cardInfo.put("heroClass",heroClass);
        cardInfo.put("rarity",rarity);
        cardInfo.put("description",description);
        cardInfo.put("HP",HP);
        cardInfo.put("Attack",Attack);
        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/"+name+".json")) {
            file.write(cardInfo.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject CardObject = new JSONObject();
        CardObject.put("MinionCard", cardInfo);
        JSONParser jsonParser = new JSONParser();
        JSONArray CardsJList = null;
        try(FileReader fileReader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
            Object obj = jsonParser.parse(fileReader);
            CardsJList = (JSONArray) obj;
            CardsJList.add(CardObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
            file.write(CardsJList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void jsonFileMakerForWeaponCards(String name, Long manaCost, String type, String heroClass, String rarity, String description, Long durability, Long Attack) {
        JSONObject cardInfo = new JSONObject();
        cardInfo.put("name",name);
        cardInfo.put("manaCost", new Long(manaCost));
        cardInfo.put("type", type);
        cardInfo.put("heroClass",heroClass);
        cardInfo.put("rarity",rarity);
        cardInfo.put("description",description);
        cardInfo.put("durability",durability);
        cardInfo.put("Attack",new Long(Attack));
        try (FileWriter file = new FileWriter(name+".json")) {
            file.write(cardInfo.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject CardObject = new JSONObject();
        CardObject.put("WeaponCard", cardInfo);
        JSONParser jsonParser = new JSONParser();
        JSONArray CardsJList = null;
        try(FileReader fileReader = new FileReader("ALLCardsExistingInGame.json")) {
            Object obj = jsonParser.parse(fileReader);
            CardsJList = (JSONArray) obj;
            CardsJList.add(CardObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter("ALLCardsExistingInGame.json")) {
            file.write(CardsJList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static card creatCard(String name) {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = null;
        try {
            reader = new FileReader( "/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards"+ name + ".json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (jsonObject.get("type").equals("SPELL")) {
            return  new Spell((long) jsonObject.get("manaCost"), (String) jsonObject.get("name"), (String) jsonObject.get("description"), card.rarity.valueOf((String) jsonObject.get("rarity")), HeroClass.valueOf((String) jsonObject.get("heroClass")) , card.type.valueOf((String) jsonObject.get("type")) , (String) jsonObject.get("Quest"), (String) jsonObject.get("Reward"));
        }
        if (jsonObject.get("type").equals("MINION")) {
            return  new Minion((long) jsonObject.get("manaCost"), (String) jsonObject.get("name"), (String) jsonObject.get("description"), card.rarity.valueOf((String) jsonObject.get("rarity")), HeroClass.valueOf((String) jsonObject.get("heroClass")) , card.type.valueOf((String) jsonObject.get("type")), (long) jsonObject.get("HP"), (long) jsonObject.get("Attack"));
        }
        else if(jsonObject.get("type").equals("WEAPON")){
            return  new Minion((long) jsonObject.get("manaCost"), (String) jsonObject.get("name"), (String) jsonObject.get("description"), card.rarity.valueOf((String) jsonObject.get("rarity")), HeroClass.valueOf((String) jsonObject.get("heroClass")) , card.type.valueOf((String) jsonObject.get("type")), (long) jsonObject.get("HP"), (long) jsonObject.get("Attack"));
        }
        else {
            return null;
        }

    }
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

}
