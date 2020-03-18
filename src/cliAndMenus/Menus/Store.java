package cliAndMenus.Menus;

import cliAndMenus.gameCLI;
import Heroes.Hero;

import java.io.IOException;
import java.util.Scanner;

import static cliAndMenus.Menus.Collections.getALLCardsExistingInGame;
import static cliAndMenus.Menus.Collections.goToCardMenu;

public class Store extends gameCLI {
    public static void goToStoreMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Boolean isValidInput1= false , isValidInput2 = false ,isValidInput3 = false , isValidInput4 = false, isValidInput5 = false;

        while (!isValidInput1) {
            System.out.println("Choose to : 1.See Cards in store 2.buy a card 3.sell a card 4.see your wallet (1/2/3/4) : ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("1") || input1.equalsIgnoreCase("See Cards in store")) {
                isValidInput1 = true;
                while (!isValidInput2){
                    System.out.println("choose to see 1.the cards you can sell them 2.the cards you can by from store (1/2) :");
                    String input2 = scanner.nextLine();
                    if(input2.equalsIgnoreCase("1")||input2.equalsIgnoreCase("the cards you can sell them")){
                        isValidInput2 = true;
                    }
                    if(input2.equalsIgnoreCase("2")||input2.equalsIgnoreCase("the cards you can by from store")){
                        isValidInput2 = true;
                        getALLCardsExistingInGame();
                    }
                    else {
                        System.out.println("invalid input!!");
                    }
                }
            }
            if(input1.equalsIgnoreCase("2") || input1.equalsIgnoreCase("buy a card")){
                isValidInput1 =true;
                buyTheCard();
               o : while (true) {
                   System.out.println("1.back to Cards Menu/ 2.buy another card? (1/2)");
                   i : switch (scanner.nextLine()) {
                        case "1":
                            goToCardMenu();
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
            }
            if(input1.equalsIgnoreCase("4") || input1.equalsIgnoreCase("see your wallet")){
                isValidInput1 =true;
                System.out.println("You have "+ gameCLI.getInstance().getCurrentPlayer().getPlayerCoins()+ " coins!");
            }
        }
    }

    public static void buyTheCard(){
        Boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter the Card's name to buy it from store");
            String cardName = new Scanner(System.in).nextLine();
            for (Cards.card card : getALLCardsExistingInGame()) {
                if (card.getName().equalsIgnoreCase(cardName)&& (card.getHeroClass().toString().equalsIgnoreCase(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().toString())||card.getHeroClass().toString().equalsIgnoreCase("NEUTRAL"))) {
                    if(card.getPrice() <= gameCLI.getInstance().getCurrentPlayer().getPlayerCoins()) {
                        gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards().add(card);
                        gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards().add(card);
                        System.out.println(cardName + "has been bought from store successfully !");
                        isValid = true;
                        break;
                    }
                    else {
                        System.out.println("you don't have enough coins to buy this card :'(  ...");
                    }
                }
            }
            System.out.println("your input is invalid!! ");
        }
    }
    public static void sellTheCard(){

    }

}
