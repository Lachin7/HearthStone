package Heroes;
import Cards.card;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.ArrayList;
import static cliAndMenus.Menus.myCollections.getALLCardsExistingInGame;

public class Warlock extends Hero {
 //   @Expose ArrayList<card> WarlockDeckCards =new ArrayList<>();
    @Expose String name = "Warlock";

    @Expose public ArrayList<card> WarlockAllCards =new ArrayList<>();
    @Override
    public  ArrayList<card> getHeroAllCards() {
        return this.WarlockAllCards;
    }

    @Override
    public String getName() {
        return "Warlock";
    }

    public Warlock() {
        this.HP = 35;
        for(Cards.card card : getALLCardsExistingInGame()) {
            if(card.getHeroClass() == Cards.card.HeroClass.WARLOCK){
                WarlockAllCards.add(card);
            }
        }
   }

    void HeroPower() {
        this.HP -=2;
        //TODO
    }

    @Override
    public String toString() {
        return "WARLOCK";
    }
}
//    public void SpecialPower() {
//    this.HP= 35;
//    }
    //    @Override
//    public  ArrayList<card> getHeroAllCards() {
//        return this.WarlockAllCards;
//    }
//    @Override
//    public void setHeroAllCards(ArrayList<card> heroAllCards) {
//        this.WarlockAllCards = heroAllCards;
//    }
    //
//    @Override
//    public ArrayList<card> getHeroDeckCards() {
//        return this.WarlockDeckCards;
//    }
//    @Override
//    public void setHeroDeckCards(ArrayList<card> heroDeckCards) {
//        this.WarlockDeckCards = heroDeckCards;
//    }


