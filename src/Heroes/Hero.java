package Heroes;

import Cards.card;
import cliAndMenus.gameCLI;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.ArrayList;

public class  Hero extends gameCLI {

   ArrayList<card> HeroDeckCards =new ArrayList<>();
   public ArrayList<card> getHeroDeckCards() {
      return HeroDeckCards;
   }
   public void setHeroDeckCards(ArrayList<card> heroDeckCards) {
      HeroDeckCards = heroDeckCards;
   }

   ArrayList<card> HeroAllCards =new ArrayList<>();
   public ArrayList<card> getHeroAllCards() throws IOException {
      return HeroAllCards;
   }
   public void setHeroAllCards(ArrayList<card> heroAllCards) {
      HeroAllCards = heroAllCards;
   }

   public String getName() {
      return null;
   }


   @Expose protected long HP;
   public long getHP() {
      return HP;
   }
   public void setHP(long HP) {
      this.HP = HP;
   }
   public void SpecialPower(){}

}

