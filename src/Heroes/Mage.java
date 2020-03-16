package Heroes;
import Cards.card;
import cliAndMenus.gameCLI;
import java.util.ArrayList;
import static Player.Player.getPlayersMageCards;

public class Mage extends HeroClass {

    ArrayList<card> PlayersMageCards;
    static Mage Mage = new Mage();

    public Mage() {
        this.PlayersMageCards = getPlayersMageCards();
        this.HP = 30;
    }

    public static Mage getInstance(){
        return Mage;
    }
    @Override
    public void SpecialPower(){
        if(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero()== this)
        for (card card :   gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()) {
            if(card.getType()== Cards.card.type.SPELL){
               card.setManaCost(card.getManaCost()-2);
            }
        }
    }

//    public void HeroPower(long manaCost , Minion minion) {
//        manaCost = 2;
//        if(gameCLI.getInstance().getCurrentPlayer().getPlayersManaInCurrentTurn() >= manaCost) {
//            minion.setHP(minion.getHP() - 1); gameCLI.getInstance().getCurrentPlayer().setPlayersManaInCurrentTurn(gameCLI.getInstance().getCurrentPlayer().getPlayersManaInCurrentTurn()-manaCost);
//        }
//        else
//            System.out.println("You don't have enough mana in this turn ");
//    }
//    public void HeroPower(long manaCost ,Hero hero) {
//        manaCost = 2;
//        if(gameCLI.getInstance().getCurrentPlayer().getPlayersManaInCurrentTurn() >= manaCost) {
//            hero.setHP(hero.getHP() - 1); gameCLI.getInstance().getCurrentPlayer().setPlayersManaInCurrentTurn(gameCLI.getInstance().getCurrentPlayer().getPlayersManaInCurrentTurn()-manaCost);
//        }
//        else
//            System.out.println("You don't have enough mana in this turn ");
//    }
}
