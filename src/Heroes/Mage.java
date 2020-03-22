package Heroes;
import Cards.card;
import cliAndMenus.gameCLI;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.ArrayList;

import static JSON.jsonForHeroes.jsonForHeroes.jsonFileMakerForHeroes;
import static cliAndMenus.Menus.myCollections.getALLCardsExistingInGame;

public class Mage extends Hero {

     @Expose String name = "Mage";

    @Expose public ArrayList<card> MageAllCards =new ArrayList<>();
    @Override
    public  ArrayList<card> getHeroAllCards() throws IOException {
        return this.MageAllCards;
    }
    @Override
    public void setHeroAllCards(ArrayList<card> heroAllCards) {
        this.MageAllCards = heroAllCards;
    }

    @Override
    public String getName() {
        return "Mage";
    }


    public Mage() {
        this.HP = 30;
        for(Cards.card card : getALLCardsExistingInGame()) {
            if(card.getHeroClass() == Cards.card.HeroClass.MAGE){
                MageAllCards.add(card);
            }
        }
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
//    for(Cards.card card : getALLCardsExistingInGame()){
//         ArrayList<card> MageAllCards =new ArrayList<>();
//         ArrayList<card> WarlockAllCards =new ArrayList<>();
//         ArrayList<card> RogueAllCards =new ArrayList<>();
//        if(card.getHeroClass() == Cards.card.HeroClass.MAGE){
//            MageAllCards.add(card);
//        }
//        if(card.getHeroClass() == Cards.card.HeroClass.ROGUE){
//           RogueAllCards.add(card);
//        }
//        if(card.getHeroClass() == Cards.card.HeroClass.WARLOCK){
//           WarlockAllCards.add(card);
//        }

    //    @Override
//    public void setHeroDeckCards(ArrayList<card> heroDeckCards) {
//        this.MageDeckCards = heroDeckCards;
//    }
//    @Override
//    public ArrayList<card> getHeroDeckCards() {
//
//        return this.MageDeckCards;
//    }

}
