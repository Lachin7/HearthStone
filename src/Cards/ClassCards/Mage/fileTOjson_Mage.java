package Cards.ClassCards.Mage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class fileTOjson_Mage {

    public static void main(String[] args){

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("MageCards.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray MageCardsList = (JSONArray) obj;
            System.out.println(MageCardsList);

            //Iterate over MageCards array
            MageCardsList.forEach(card -> parseCardObject((JSONObject) card));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseCardObject(JSONObject card){

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
    }
}
