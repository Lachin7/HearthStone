package cliAndMenus.Menus;

import cliAndMenus.gameCLI;
import Heroes.Hero;

import java.util.Scanner;

import static cliAndMenus.Menus.Collections.getALLCardsExistingInGame;

public class Store {
    public static void goToStoreMenu(){
        Scanner scanner = new Scanner(System.in);
        Boolean isValidInput1= false , isValidInput2 = false ,isValidInput3 = false , isValidInput4 = false, isValidInput5 = false;

        while (!isValidInput1) {
            System.out.println("Choose to : 1.See Cards in store 2.buy a card 3.sell a card 4.see your wallet (1/2/3/4) : ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("1") || input1.equalsIgnoreCase("See Cards in store")) {
                isValidInput1 = true;
                while (isValidInput2){
                    System.out.println("choose to see 1.the cards you can sell them 2.the cards you can by from store (1/2) :");
                    String input2 = scanner.nextLine();
                    if(input2.equalsIgnoreCase("1")||input2.equalsIgnoreCase("the cards you can sell them")){
                        isValidInput2 = true;
                        //TODO
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
                //TODO
                if (card.getName().equalsIgnoreCase(cardName)&& (Hero) card.getHeroClass()==gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero()) {
                    gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards().remove(card);
                    System.out.println(cardName + "has been bought from store successfully !");
                    isValid = true;
                    break;
                }
            }
            System.out.println("your input is invalid!! ");
        }
    }
    public static void sellTheCard(){}

}
