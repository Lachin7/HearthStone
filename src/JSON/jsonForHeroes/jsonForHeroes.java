package JSON.jsonForHeroes;

import Cards.card;
import Heroes.Hero;
import Heroes.Mage;
import Heroes.Rogue;
import Heroes.Warlock;
import com.google.gson.*;
import java.io.*;


public class jsonForHeroes {

    public static void jsonFileMakerForHeroes(Hero hero) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("src/JSON/jsonForHeroes/jsonFilesForHeroes/" + hero.getName() + ".json");
        gson.toJson(hero, fileWriter);
        fileWriter.close();
    }
    //jsonFileMakerForHeroes(new Mage()); jsonFileMakerForHeroes(new Rogue()); jsonFileMakerForHeroes(new Warlock());


}
