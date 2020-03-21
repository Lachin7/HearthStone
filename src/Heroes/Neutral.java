package Heroes;
import Cards.card;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static JSON.jsonForHeroes.jsonForHeroes.jsonFileMakerForHeroes;
import static cliAndMenus.Menus.myCollections.getALLCardsExistingInGame;

public class Neutral extends Hero {

  //  static Neutral Neutral = new Neutral();
  @Expose
  public ArrayList<card> NuetralAllCards =new ArrayList<>();

    public Neutral() {
        for(Cards.card card : getALLCardsExistingInGame()) {
            if(card.getHeroClass() == Cards.card.HeroClass.NEUTRAL){
                NuetralAllCards.add(card);
            }
        }
    }
//    public static Neutral getInstance(){
//        return Neutral;
//    }
    @Override
    public String toString() {
        return "NEUTRAL";
    }

    @Override
    public String getName() {
        return "Neutral";
    }

//    public static void main(String[] args) throws IOException {
//        jsonFileMakerForHeroes(new Neutral());
//    }
}
