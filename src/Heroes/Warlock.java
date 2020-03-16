package Heroes;
import Cards.card;
import java.util.ArrayList;
import static Player.Player.getPlayersWarlockCards;

public class Warlock extends HeroClass {
    ArrayList<card> PlayersWarlockCards ;
    static Warlock Warlock = new Warlock();
    public Warlock() {
        PlayersWarlockCards = getPlayersWarlockCards();
        this.HP = 35;
    }
    public static Warlock getInstance(){
        return Warlock;
    }

    void HeroPower() {
        this.HP -=2;
        //TODO
    }
//    public void SpecialPower() {
//    this.HP= 35;
//    }
}
