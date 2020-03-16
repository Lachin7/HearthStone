package cliAndMenus.Menus;

import cliAndMenus.gameCLI;
import Cards.card;
import Heroes.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;

public class Collections {
    public static void goToCollectionsMenu() {
        System.out.println(gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards());
        Scanner scanner = new Scanner(System.in);
        Boolean isValidInput1= false , isValidInput2 = false ,isValidInput3 = false , isValidInput4 = false;

        while (!isValidInput1) {
            System.out.println("you can go to either Heroes or Cards (H/C)");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("H") || input1.equalsIgnoreCase("Heroes")) {
                isValidInput1 = true;
                System.out.println("Choose to 1.see All heroes 2.see your hero 3.Change your hero (1/2/3):");
                String input2 = scanner.nextLine();
                while (!isValidInput2) {
                    if (input2.equalsIgnoreCase("1") || input2.equalsIgnoreCase("see All heroes")) {
                        isValidInput2 = true;
                        System.out.println("Available heroes in this game edition are : *Mage* *Rouge* *Warlock* ");
                    }
                    if (input2.equalsIgnoreCase("2") || input2.equalsIgnoreCase("see your hero")) {
                        isValidInput2 = true;
                        System.out.println("your hero is "+gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero() + " !");
                    }
                    if (input2.equalsIgnoreCase("3") || input2.equalsIgnoreCase("Change your hero")) {
                        chooseTheHero();
                    }
                    else {
                        System.out.println("Wrong input!!");
                    }
                }
            }

            if(input1.equalsIgnoreCase("C") || input1.equalsIgnoreCase("Cards")){
                isValidInput1 = true;
                System.out.println("Choose to : 1.See Cards / 2.Add a Card / 3.Delete a Card");
                String input3 = scanner.nextLine();
                while (!isValidInput3) {
                    if (input3.equalsIgnoreCase("1") || input3.equalsIgnoreCase("See Cards")) {
                        isValidInput3 = true;
                        System.out.println("Choose to : 1.See ALL your Cards 2.See your Deck Cards 3.See the Cards you can add to your Deck");
                        String input4 = scanner.nextLine();
                        while (!isValidInput4){
                            if(input4.equalsIgnoreCase("1")||input4.equalsIgnoreCase("See ALL your Cards")){
                                isValidInput4 =true;
                                System.out.println(gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards());
                            }
                            if(input4.equalsIgnoreCase("2")||input4.equalsIgnoreCase("See your Deck Cards ")){
                                isValidInput4 =true;
                                System.out.println(gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards());
                            }
                            if(input4.equalsIgnoreCase("3")||input4.equalsIgnoreCase("See the Cards you can add to your Deck")){
                                isValidInput4 =true;
                                for (Cards.card card : gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards()) {
                                    if(!gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards().contains(card)){
                                        System.out.println(card);
                                    }
                                }
                            }
                            else {
                                System.out.println("Wrong input!!");
                            }
                        }
                    }
                    if (input3.equalsIgnoreCase("2") || input3.equalsIgnoreCase("Add a Card")) {
                        isValidInput3 = true;
                        chooseTheHero();
                        addCardToDeck();
                    }
                    if (input3.equalsIgnoreCase("3") || input3.equalsIgnoreCase("Delete a Card")) {
                        isValidInput3 = true;
                        chooseTheHero();
                        removeCardFromDeck();
                    }
                    else {
                        System.out.println("Wrong input!!");
                    }
                }
            }
            else {
                System.out.println("Wrong input!!");
            }
        }
    }

    public static void addCardToDeck(){
        Boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter the Card's name to add it to your deck : ");
            String cardName = new Scanner(System.in).nextLine();
            for (card card : gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()) {
                if (card.getName().equalsIgnoreCase(cardName)   && card.getHeroClass() ==  gameCLI.getInstance().getPlayersChoosedHero()) {
                    gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards().add(card);
                    System.out.println(cardName + "has been added to your deck successfully !");
                    isValid = true;
                    break;
                }
            }
            System.out.println("your input is invalid!! ");
        }
    }
    public static void removeCardFromDeck(){
        Boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter the Card's name to delete it from your deck");
            String cardName = new Scanner(System.in).nextLine();
            for (card card : gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards()) {
                if (card.getName().equalsIgnoreCase(cardName)) {
                    gameCLI.getInstance().getCurrentPlayer().getPlayersDeckCards().remove(card);
                    System.out.println(cardName + "has been deleted from your deck successfully !");
                    isValid = true;
                    break;
                }
            }
            System.out.println("your input is invalid!! ");
        }
    }
    public static void chooseTheHero(){
        System.out.println("Choose your Hero : 1.Mage 2.Rouge 3.Warlock (1/2/3)");
        String heroName = new Scanner(System.in).nextLine();
        Boolean isvalid = false;
        while (!isvalid){
            if(heroName.equalsIgnoreCase("Mage") || heroName.equalsIgnoreCase("1")){
                gameCLI.getInstance().getCurrentPlayer().setPlayersChoosedHero(Mage.getInstance()); isvalid =true;
            }
            if(heroName.equalsIgnoreCase("Rouge") || heroName.equalsIgnoreCase("2")){
                gameCLI.getInstance().getCurrentPlayer().setPlayersChoosedHero(Rogue.getInstance()); isvalid =true;
            }
            if(heroName.equalsIgnoreCase("Warlock") || heroName.equalsIgnoreCase("3")){
                gameCLI.getInstance().getCurrentPlayer().setPlayersChoosedHero(Warlock.getInstance()); isvalid =true;
            }
            else {
                System.out.println("invalid input!!");
            }
        }
        System.out.println("your current hero is "+ heroName);
    }

    public static ArrayList<card> getALLCardsExistingInGame(){
       // ArrayList<card> arrayList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("ALLCardsExistingInGame.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = jsonParser.parse(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray CardsJList = (JSONArray) obj;
        ArrayList<card> arrayList = new ArrayList<>();
        for (Object object : CardsJList) {
            arrayList.add((card)object);
        }
        return arrayList;
    }


}
