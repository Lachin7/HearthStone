package Heroes;
import Cards.card;
import cliAndMenus.gameCLI;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Mage extends Hero {

    @Expose ArrayList<card> MageDeckCards =new ArrayList<>();
    @Override
    public void setHeroDeckCards(ArrayList<card> heroDeckCards) {
        this.MageDeckCards = heroDeckCards;
    }
    @Override
    public ArrayList<card> getHeroDeckCards() {
        return this.MageDeckCards;
    }

    public Mage() {
        this.HP = 30; }

    @Override
    public void SpecialPower(){
        if(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero()== this)
        for (card card :   gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()) {
            if(card.getType()== Cards.card.type.SPELL){
               card.setManaCost(card.getManaCost()-2);
            }
        }
    }
    @Override
    public String toString() {
        return "MAGE";
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
