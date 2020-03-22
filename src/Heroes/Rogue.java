package Heroes;

import Cards.card;
import cliAndMenus.gameCLI;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.ArrayList;

import static cliAndMenus.Menus.myCollections.getALLCardsExistingInGame;

public class Rogue extends Hero {

 //   @Expose ArrayList<card> RogueDeckCards =new ArrayList<>();
    @Expose String name = "Rogue";
//    @Override
//    public void setHeroDeckCards(ArrayList<card> heroDeckCards) {
//        this.RogueDeckCards = heroDeckCards;
//    }
//    @Override
//    public ArrayList<card> getHeroDeckCards() {
//        return this.RogueDeckCards;
//    }

    @Expose public ArrayList<card> RogueAllCards =new ArrayList<>();
    @Override
    public  ArrayList<card> getHeroAllCards() {
        return RogueAllCards;
    }
//    @Override
//    public  ArrayList<card> getHeroAllCards() {
//        return this.RogueAllCards;
//    }
//    @Override
//    public void setHeroAllCards(ArrayList<card> heroAllCards) {
//        this.RogueAllCards = heroAllCards;
//    }

    @Override
    public String getName() {
        return "Rogue";
    }

    public Rogue() {
        this.HP = 30;
        for(Cards.card card : getALLCardsExistingInGame()) {
            if(card.getHeroClass() == Cards.card.HeroClass.ROGUE){
                RogueAllCards.add(card);
            }
        }
    }

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
