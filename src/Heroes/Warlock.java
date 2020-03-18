package Heroes;
import Cards.card;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.lang.reflect.Modifier;

public class Warlock extends Hero {
    @Expose ArrayList<card> WarlockDeckCards =new ArrayList<>();
    @Override
    public void setHeroDeckCards(ArrayList<card> heroDeckCards) {
        this.WarlockDeckCards = heroDeckCards;
    }
    @Override
    public ArrayList<card> getHeroDeckCards() {
        return this.WarlockDeckCards;
    }
   // static Warlock Warlock = new Warlock();
    public Warlock() {
      //  PlayersWarlockCards = getPlayersWarlockCards();
        this.HP = 35;
   }
//    public static Warlock getInstance(){
//        return Warlock;
//    }

    void HeroPower() {
        this.HP -=2;
        //TODO
    }
//    public void SpecialPower() {
//    this.HP= 35;
//    }
@Override
public String toString() {
    return "WARLOCK";
}
}
