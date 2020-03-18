package JSON.jsonForCards;

import Cards.*;
import Cards.card.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class jsonForCards {

    public static void jsonFileMakerForCards(card card) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/" + card.getName() + ".json");
        gson.toJson(card, fileWriter);
        fileWriter.close();
    }

//    public static void main(String[] args) throws IOException {
//        for(card card : AllExistingCards){
//            jsonFileMakerForCards(card);
//        }
//    }

    public static card creatCardFromjson(String name) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        FileReader fileReader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/" + name + ".json");
        card card = gson.fromJson(fileReader, card.class);
        fileReader.close();
        return card;
    }

    static public Spell Polymorph = new Spell(4, "Polymorph", "Transform minion in to a 1/1 sheep.", card.rarity.RARE, card.HeroClass.MAGE, card.type.SPELL, 10, "", "");
    //AllExistingCardsInGame
    static public Spell RollingFireball = new Spell(5, "RollingFireball", "Deal 8 damage to a minion. Any excess damage continues to the left or right.1 sheep.", card.rarity.EPIC, card.HeroClass.MAGE, type.SPELL, 15, "", "");
    static public Spell FriendlySmith = new Spell(1, "FriendlySmith", "Discover a weapon from any class. Add it to your Adventure Deck with +2/+2", card.rarity.COMMON, card.HeroClass.ROGUE, type.SPELL, 5, "", "");
    static Spell BlinkFox = new Spell(3, "BlinkFox", "Battlecry: Add a random card to your hand (from your opponent's class).", card.rarity.COMMON, card.HeroClass.ROGUE, card.type.SPELL, 5, "", "");
    static Minion Ratcatcher = new Minion(3, "Ratcatcher", "Rush   Battlecry: Destroy a friendly minion and gain its Attack and Health.", card.rarity.LEGENDARY, card.HeroClass.WARLOCK, type.MINION, 20, 2, 2);
    //  static Minion Ratcatcher3 = new Minion(3,"Ratcatcher","Rush   Battlecry: Destroy a friendly minion and gain its Attack and Health.", rarity.LEGENDARY, HeroClass.WARLOCK, type.MINION,2,2);
    static Minion AbusiveSergeant = new Minion(1, "AbusiveSergeant", "Battlecry: Give a minion +2 Attack this turn.", card.rarity.COMMON, card.HeroClass.NEUTRAL, card.type.MINION, 5, 1, 1);
    static Minion HungryCrab = new Minion(1, "HungryCrab", "Destroy a Murloc and gain +2/+2.", rarity.EPIC, card.HeroClass.NEUTRAL, card.type.MINION, 15, 2, 1);
    static Minion GoblinBomb = new Minion(2, "GoblinBomb", "Deal 2 damage to the enemy hero.", rarity.COMMON, card.HeroClass.NEUTRAL, type.MINION, 5, 2, 0);
    static Minion BeamingSidekick = new Minion(1, "BeamingSidekick", "Give a friendly minion +2 Health.", rarity.COMMON, card.HeroClass.NEUTRAL, type.MINION, 5, 2, 1);
    static Minion LostSpirit = new Minion(2, "LostSpirit", "Deathrattle: Give your minions +1 Attack.", card.rarity.COMMON, card.HeroClass.NEUTRAL, type.MINION, 5, 1, 1);
    static Minion MagmaRager = new Minion(3, "MagmaRager", "-", card.rarity.COMMON, card.HeroClass.NEUTRAL, card.type.MINION, 5, 1, 5);
    static Minion MurlocRaider = new Minion(1, "MurlocRaider", "-", card.rarity.COMMON, card.HeroClass.NEUTRAL, card.type.MINION, 5, 1, 2);
    static Spell Backstab = new Spell(0, "Backstab", "Deal 2 damage to an undamaged minion.", card.rarity.COMMON, card.HeroClass.NEUTRAL, card.type.SPELL, 5, "", "");
    static Spell MalygossFrostbolt = new Spell(0, "MalygossFrostbolt", "Deal 3 damage to a character and Freeze it.", card.rarity.COMMON, card.HeroClass.NEUTRAL, card.type.SPELL, 5, "", "");
    static Spell MalygossNova = new Spell(1, "MalygossNova", "Freeze all enemy minions.", card.rarity.RARE, card.HeroClass.NEUTRAL, card.type.SPELL, 10, "", "");
    static Spell MalygossExplosion = new Spell(1, "MalygossExplosion", "Deal 2 damage to all enemy minions.", card.rarity.RARE, card.HeroClass.NEUTRAL, type.SPELL, 10, "", "");
    static Spell TimeRip = new Spell(5, "TimeRip", "Destroy a minion. Invoke Galakrond.", rarity.RARE, card.HeroClass.NEUTRAL, type.SPELL, 10, "", "");
    static Spell CandleBreath = new Spell(6, "CandleBreath", "Destroy a minion. Invoke Galakrond.", card.rarity.COMMON, card.HeroClass.NEUTRAL, card.type.SPELL, 5, "", "");
    static Weapon LightsJustice = new Weapon(1, "LightsJustice", "", rarity.COMMON, card.HeroClass.NEUTRAL, card.type.WEAPON, 5, 4, 1);
    static Weapon SerratedTooth = new Weapon(1, "SerratedTooth", "Deathrattle: Give your minions Rush.", card.rarity.COMMON, card.HeroClass.NEUTRAL, card.type.WEAPON, 5, 1, 1);
    static Weapon HeadhuntersHatchet = new Weapon(1, "HeadhuntersHatchet", "Battlecry: If you control a Beast, gain +1 Durability.", card.rarity.COMMON, card.HeroClass.NEUTRAL, type.WEAPON, 5, 2, 1);


    public static void main(String[] args) throws IOException {
//        jsonFileMakerForCards(Polymorph);
//        jsonFileMakerForCards(RollingFireball);
//        jsonFileMakerForCards(FriendlySmith);
//        jsonFileMakerForCards(BlinkFox);
//        jsonFileMakerForCards(Ratcatcher);
//        jsonFileMakerForCards(AbusiveSergeant);
//        jsonFileMakerForCards(HungryCrab);
//        jsonFileMakerForCards(GoblinBomb);
//        jsonFileMakerForCards(BeamingSidekick);
//        jsonFileMakerForCards(LostSpirit);
//        jsonFileMakerForCards(MagmaRager);
//        jsonFileMakerForCards(MurlocRaider);
//        jsonFileMakerForCards(Backstab);
//        jsonFileMakerForCards(MalygossFrostbolt);
//        jsonFileMakerForCards(MalygossNova);
//        jsonFileMakerForCards(MalygossExplosion);
//        jsonFileMakerForCards(TimeRip);
//        jsonFileMakerForCards(CandleBreath);
//        jsonFileMakerForCards(LightsJustice);
//        jsonFileMakerForCards(SerratedTooth);
//        jsonFileMakerForCards(HeadhuntersHatchet);
        System.out.println(Polymorph.getHeroClass().toString());
        // public  ArrayList<card> AllExistingCardsInGame = new ArrayList();


//    public static void jsonFileMakerForSpellCards(String name, Long manaCost, String type, String heroClass, String rarity, String description, String Quest, String Reward) {
//        JSONObject cardInfo = new JSONObject();
//        cardInfo.put("name",name);
//        cardInfo.put("manaCost", new Long(manaCost));
//        cardInfo.put("type", type);
//        cardInfo.put("heroClass",heroClass);
//        cardInfo.put("rarity",rarity);
//        cardInfo.put("description",description);
//        cardInfo.put("Quest",Quest);
//        cardInfo.put("Reward",Reward);
//        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/"+ name +".json")) {
//            file.write(cardInfo.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONObject CardObject = new JSONObject();
//        CardObject.put("SpellCard", cardInfo);
//        JSONParser jsonParser = new JSONParser();
//        JSONArray CardsJList = null;
//        try(FileReader fileReader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
//            Object obj = jsonParser.parse(fileReader);
//            CardsJList = (JSONArray) obj;
//            CardsJList.add(CardObject);
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//
//        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
//            file.write(CardsJList.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void jsonFileMakerForMinionCards(String name, Long manaCost, String type, String heroClass, String rarity, String description, Long HP, Long Attack) {
//        JSONObject cardInfo = new JSONObject();
//        cardInfo.put("name",name);
//        cardInfo.put("manaCost", new Long(manaCost));
//        cardInfo.put("type", type);
//        cardInfo.put("heroClass",heroClass);
//        cardInfo.put("rarity",rarity);
//        cardInfo.put("description",description);
//        cardInfo.put("HP",HP);
//        cardInfo.put("Attack",Attack);
//        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/"+name+".json")) {
//            file.write(cardInfo.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONObject CardObject = new JSONObject();
//        CardObject.put("MinionCard", cardInfo);
//        JSONParser jsonParser = new JSONParser();
//        JSONArray CardsJList = null;
//        try(FileReader fileReader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
//            Object obj = jsonParser.parse(fileReader);
//            CardsJList = (JSONArray) obj;
//            CardsJList.add(CardObject);
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//
//        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
//            file.write(CardsJList.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void jsonFileMakerForWeaponCards(String name, Long manaCost, String type, String heroClass, String rarity, String description, Long durability, Long Attack) {
//        JSONObject cardInfo = new JSONObject();
//        cardInfo.put("name",name);
//        cardInfo.put("manaCost", new Long(manaCost));
//        cardInfo.put("type", type);
//        cardInfo.put("heroClass",heroClass);
//        cardInfo.put("rarity",rarity);
//        cardInfo.put("description",description);
//        cardInfo.put("durability",durability);
//        cardInfo.put("Attack",new Long(Attack));
//        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/"+name+".json")) {
//            file.write(cardInfo.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONObject CardObject = new JSONObject();
//        CardObject.put("WeaponCard", cardInfo);
//        JSONParser jsonParser = new JSONParser();
//        JSONArray CardsJList = null;
//        try(FileReader fileReader = new FileReader("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
//            Object obj = jsonParser.parse(fileReader);
//            CardsJList = (JSONArray) obj;
//            CardsJList.add(CardObject);
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//
//        try (FileWriter file = new FileWriter("/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/ALLCardsExistingInGame.json")) {
//            file.write(CardsJList.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//
//    public static card creatCard(String name) {
//
//        JSONParser jsonParser = new JSONParser();
//        FileReader reader = null;
//        try {
//            reader = new FileReader( "/Users/shahinnaghashyar/Desktop/HearthStone/src/JSON/jsonForCards/jsonFilesForCards/"+ name +".json");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = (JSONObject) jsonParser.parse(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        if (jsonObject.get("type").equals("SPELL")) {
//            return  new Spell((long) jsonObject.get("manaCost"), (String) jsonObject.get("name"), (String) jsonObject.get("description"), card.rarity.valueOf((String) jsonObject.get("rarity")), HeroClass.valueOf((String) jsonObject.get("heroClass")) , card.type.valueOf((String) jsonObject.get("type")) , (String) jsonObject.get("Quest"), (String) jsonObject.get("Reward"));
//        }
//        if (jsonObject.get("type").equals("MINION")) {
//            return  new Minion((long) jsonObject.get("manaCost"), (String) jsonObject.get("name"), (String) jsonObject.get("description"), card.rarity.valueOf((String) jsonObject.get("rarity")), HeroClass.valueOf((String) jsonObject.get("heroClass")) , card.type.valueOf((String) jsonObject.get("type")), (long) jsonObject.get("HP"), (long) jsonObject.get("Attack"));
//        }
//        else if(jsonObject.get("type").equals("WEAPON")){
//            return  new Minion((long) jsonObject.get("manaCost"), (String) jsonObject.get("name"), (String) jsonObject.get("description"), card.rarity.valueOf((String) jsonObject.get("rarity")), HeroClass.valueOf((String) jsonObject.get("heroClass")) , card.type.valueOf((String) jsonObject.get("type")), (long) jsonObject.get("durability"), (long) jsonObject.get("Attack"));
//        }
//        else {
//            return null;
//        }
//
//    }
//    public static void convertFileToJsonForCards(String fileName){
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
//                parseCardObject((JSONObject)Jlist.get(i));
//            }
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
//    public static void parseCardObject(JSONObject card){
//
//        //Get card object within list
//        JSONObject cardObject = (JSONObject) card.get("card");
//
//        //Get card first name
//        String name = (String) cardObject.get("name");
//        System.out.println(name);
//
//        //Get card mana cost
//        String manaCost = (String) cardObject.get("manaCost");
//        System.out.println(manaCost);
//
//        //Get card type
//        String type = (String) cardObject.get("type");
//        System.out.println(type);
//
//        //Get card first heroClass
//        String heroClass = (String) cardObject.get("heroClass");
//        System.out.println(heroClass);
//
//        //Get card  rarity
//        String rarity = (String) cardObject.get("rarity");
//        System.out.println(rarity);
//
//        //Get card description
//        String description = (String) cardObject.get("description");
//        System.out.println(description + "\n");
//
//
//    }

    }
}
