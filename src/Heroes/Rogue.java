package Heroes;

import Cards.card;
import cliAndMenus.gameCLI;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Rogue extends Hero {

    @Expose ArrayList<card> RogueDeckCards =new ArrayList<>();
    @Override
    public void setHeroDeckCards(ArrayList<card> heroDeckCards) {
        this.RogueDeckCards = heroDeckCards;
    }
    @Override
    public ArrayList<card> getHeroDeckCards() {
        return this.RogueDeckCards;
    }
 //   static Rogue Rouge = new Rogue();

    public Rogue() {
        this.HP = 30;
    }
//    public static Rogue getInstance(){
//        return Rouge;
//    }

    public void SpecialPower() {
        if (gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero() == this) {
            for (card card : gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()) {
//                if ((Rogue) card.getHeroClass()!= Rogue.getInstance()|| card.getHeroClass() != (HeroClass) Neutral.getInstance()) {
//                    card.setManaCost(card.getManaCost() - 2);
//                }
            }
        }
    }

//    public void HeroPower(){
//        Random random = new Random(enemyPlayer.getPlayersDeckCards().size());
//        gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards().add(enemyPlayer.getPlayersDeckCards().get(random.nextInt()));
//    }
//    public void UpgratedHeroPower(){
//        Random random = new Random(enemyPlayer.getPlayersDeckCards().size());
//        gameCLI.getInstance().getCurrentPlayer().getPlayersBoardCards().add(enemyPlayer.getPlayersDeckCards().get(random.nextInt()));
//        Random random2 = new Random(gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards().size());
//        gameCLI.getInstance().getCurrentPlayer().getPlayersBoardCards().add(gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards().get(random.nextInt()));
//    }
@Override
public String toString() {
    return "ROGUE";
}

}
