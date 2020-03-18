package Heroes;

import Cards.card;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public abstract class  Hero {

  @Expose ArrayList<card> HeroDeckCards =new ArrayList<>();
   public ArrayList<card> getHeroDeckCards() {
      return HeroDeckCards;
   }
   public void setHeroDeckCards(ArrayList<card> heroDeckCards) {
      HeroDeckCards = heroDeckCards;
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

