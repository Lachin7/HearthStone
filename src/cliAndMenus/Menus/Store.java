package cliAndMenus.Menus;

import Cards.card;
import cliAndMenus.gameCLI;
import Heroes.Hero;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import static JSON.jsonForCards.jsonForCards.creatCardFromjson;
import static JSON.jsonForPlayers.jsonForPlayers.jsonTofilePlayer;
import static cliAndMenus.Menus.myCollections.getALLCardsExistingInGame;

public class Store extends gameCLI {

    private static Store store = new Store();
    public static Store getInstance(){return store;}
    public void goToStoreMenu() throws IOException {
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"OPENED_STORE");
        Scanner scanner = new Scanner(System.in);
        Boolean isValidInput1= false , isValidInput2 = false ;

        while (!isValidInput1) {
            System.out.println("Choose to : 1.See Cards in store 2.buy a card 3.sell a card 4.see your wallet (1/2/3/4/back) : ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("1") || input1.equalsIgnoreCase("See Cards in store")) {
                isValidInput1 = true;
                while (!isValidInput2){
                    System.out.println("choose to see 1.the cards you can sell them 2.the cards you can by from store (1/2) :");
                    String input2 = scanner.nextLine();
                    if(input2.equalsIgnoreCase("1")||input2.equalsIgnoreCase("the cards you can sell them")){
                        isValidInput2 = true;
                        showCardsUCanSell();
                    }
                    if(input2.equalsIgnoreCase("2")||input2.equalsIgnoreCase("the cards you can buy from store")){
                        isValidInput2 = true;
                        getALLCardsExistingInGame();
                    }
                    if(input2.equalsIgnoreCase("back")){
                        isValidInput2 = true;
                        gameCLI.getInstance().goToMenus();
                    }
                    else {
                        System.out.println("invalid input!!");
                        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input  IN_LINE:45");
                    }
                }
            }
            if(input1.equalsIgnoreCase("2") || input1.equalsIgnoreCase("buy a card")){
                isValidInput1 =true;
                buyTheCard();
               o : while (true) {
                   System.out.println("1.back to Store Menu/ 2.buy another card? (1/2)");
                   i : switch (scanner.nextLine()) {
                        case "1":
                            goToStoreMenu();
                            break o ;
                        case "2":
                            buyTheCard();
                            break o ;
                        default:
                            System.out.println("invalid input");
                            break i;
                    }
                }
            }
            if(input1.equalsIgnoreCase("3") || input1.equalsIgnoreCase("sell a card")){
                isValidInput1 =true;
                sellTheCard();
                o : while (true) {
                    System.out.println("1.back to Store Menu/ 2.sell another card? (1/2)");
                    i : switch (scanner.nextLine()) {
                        case "1":
                            goToStoreMenu();
                            break o ;
                        case "2":
                            sellTheCard();
                            break o ;
                        default:
                            System.out.println("invalid input");
                            break i;
                    }
                }
            }
            if(input1.equalsIgnoreCase("4") || input1.equalsIgnoreCase("see your wallet")){
                isValidInput1 =true;
                System.out.println("You have "+ gameCLI.getInstance().getCurrentPlayer().getPlayerCoins()+ " coins!");
            }
        }
    }
    public static void buyTheCard() throws IOException {
        Boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter the Card's name to buy it from store");
            String cardName = new Scanner(System.in).nextLine();
            for (Cards.card card : getALLCardsExistingInGame()) {
                if (card.getName().equalsIgnoreCase(cardName)&& (card.getHeroClass().toString().equalsIgnoreCase(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().toString())||card.getHeroClass().toString().equalsIgnoreCase("NEUTRAL"))) {
                    if(card.getPrice() <= gameCLI.getInstance().getCurrentPlayer().getPlayerCoins()) {
                        gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards().add(card);
                        gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards().add(card);
                        gameCLI.getInstance().getCurrentPlayer().setPlayerCoins(gameCLI.getInstance().getCurrentPlayer().getPlayerCoins() - card.getPrice());
                        System.out.println(cardName + "has been bought from store successfully !");
                        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"bought this card from store : " + card.toString());
                        jsonTofilePlayer(gameCLI.getInstance().getCurrentPlayer());
                        isValid = true;
                        break;
                    }
                    else {
                        System.out.println("you don't have enough coins to buy this card :'(  ...");
                    }
                }
            }
            System.out.println("your input is invalid!! ");
            gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input  IN_LINE:115");
        }
    }
    public  void showCardsUCanSell(){
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"SHOW_CARDS_USER_CAN_SELL");
        System.out.println("lets see which cards you can sell : ");
        for(card card : gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()){
            boolean canSell = true;
            for (Hero hero : gameCLI.getInstance().getCurrentPlayer().getPlayersUnlockedHeroes()){
                for(card card1 : hero.getHeroDeckCards()){
                    if(card == card1){
                        canSell = false;
                    }
                }
            }
            if(canSell==true){
                System.out.println(card.toString());
            }
        }
    }
    public  void sellTheCard() throws IOException {
        showCardsUCanSell();
        System.out.println("enter the cards name for sell : ");
        card inputCard = creatCardFromjson(new Scanner(System.in).nextLine());
        boolean canSell = true;
        for (Hero hero : gameCLI.getInstance().getCurrentPlayer().getPlayersUnlockedHeroes()){
            for(card card1 : hero.getHeroDeckCards()){
                if(inputCard == card1){
                    canSell = false;
                }
            }
        }
        if(canSell==true){
            gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards().remove(inputCard); gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards().remove(inputCard);
            gameCLI.getInstance().getCurrentPlayer().setPlayerCoins(gameCLI.getInstance().getCurrentPlayer().getPlayerCoins() + inputCard.getPrice() - 4 );
            gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"SOLD_THE_CARD : " + inputCard.toString());
            jsonTofilePlayer(gameCLI.getInstance().getCurrentPlayer());
            System.out.println("you sold your card successfully");
        }

    }

}
