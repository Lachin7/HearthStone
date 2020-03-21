package cliAndMenus.Menus;
import cliAndMenus.gameCLI;
import Cards.card;
import com.google.gson.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import static JSON.jsonForPlayers.jsonForPlayers.jsonTofilePlayer;

public class myCollections extends gameCLI{

    private static myCollections collections = new myCollections();
    public static myCollections getInstance(){return collections;}

    public void goToCollectionsMenu() throws IOException {
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"OPENED_COLLECTIONS_MENU");
        System.out.println("Let's look at all of your cards :D  \n"+gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("you can go to either Heroes or Cards (h/c/back/help)");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("H") || input1.equalsIgnoreCase("Heroes")) {
                goToHeroMenu();break;
            }
            if (input1.equalsIgnoreCase("C") || input1.equalsIgnoreCase("Cards")) {
                goToCardMenu();break;
            }
            if(input1.equalsIgnoreCase("help")){
                help();break;
            }
            if(input1.equalsIgnoreCase("back")){
                gameCLI.getInstance().goToMenus();break;
            }
            else {
                System.out.println("Wrong input!!");
                gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input  IN_LINE:37");
            }
        }
    }

    public void goToHeroMenu() throws IOException {
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"OPENED_HEROES_MENU");
        Scanner scanner = new Scanner(System.in); Boolean isValidInput2 = false;
        System.out.println("Choose to 1.see All heroes 2.see your current  hero 3.Change your hero (1/2/3/back):");
        String input2 = scanner.nextLine();
        while (!isValidInput2) {
            if (input2.equalsIgnoreCase("1") || input2.equalsIgnoreCase("see All heroes")) {
                isValidInput2 = true;
                System.out.println("Available heroes in this game edition are : *Mage* *Rouge* *Warlock*  \n  also your unlocked heroes are : " + gameCLI.getInstance().getCurrentPlayer().getPlayersUnlockedHeroes().toString() +  " \n go back?(y)");
                BackForHeroMenu();
            }
            if (input2.equalsIgnoreCase("2") || input2.equalsIgnoreCase("see your current hero")) {
                isValidInput2 = true;
                System.out.println("your hero is  :" + gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero() + " !  \n go back?(y)");
                BackForHeroMenu();
            }
            if (input2.equalsIgnoreCase("3") || input2.equalsIgnoreCase("Change your hero")) {
                chooseTheHero();
                System.out.println("go back(y)");
                BackForHeroMenu();
            }
            if (input2.equalsIgnoreCase("back")) {
                goToCollectionsMenu();
            } else {
                System.out.println("Wrong input!!");
                gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input  IN_LINE:71");
            }
        }
    }

    public void BackForHeroMenu() throws IOException {
        while (true) {
            if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
                goToHeroMenu();
                break;
            } else {
                System.out.println("invalid input! type 'y' to go back to hero menu");
            }
        }
    }

    public void chooseTheHero() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose your Hero : 1.Mage 2.Rouge 3.Warlock (1/2/3/back)");
            String heroName = scanner.nextLine();
            if(heroName.equalsIgnoreCase("Mage") || heroName.equalsIgnoreCase("1")){
                gameCLI.getInstance().getCurrentPlayer().setPlayersChoosedHero(gameCLI.getInstance().getCurrentPlayer().PlayersMage);  break;
            }
            if(heroName.equalsIgnoreCase("Rogue") || heroName.equalsIgnoreCase("2")){
                System.out.println("this hero is locked , enter test to do so ");
                if(scanner.nextLine().equalsIgnoreCase("test")) {
                    gameCLI.getInstance().getCurrentPlayer().setPlayersChoosedHero(gameCLI.getInstance().getCurrentPlayer().PlayersRogue);break;
                }
            }
            if(heroName.equalsIgnoreCase("Warlock") || heroName.equalsIgnoreCase("3")){
                System.out.println("this hero is locked , enter test to do so ");
                if(scanner.nextLine().equalsIgnoreCase("test")){
                    gameCLI.getInstance().getCurrentPlayer().setPlayersChoosedHero(gameCLI.getInstance().getCurrentPlayer().PlayersWarlock); break;
                }
            }
            if(heroName.equalsIgnoreCase("back")){
                goToHeroMenu();break;
            }
            else {
                System.out.println("invalid input!!");
                gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input  IN_LINE:108");
            }
        }
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"CHANGED_HERO");
        System.out.println("your hero changed successfully " );
        jsonTofilePlayer(gameCLI.getInstance().getCurrentPlayer());
    }

    public void goToCardMenu() throws IOException {
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"OPENED_CARD_MENU");
        Boolean isValidInput3 = false, isValidInput4 = false; Scanner scanner = new Scanner(System.in);
        while (!isValidInput3) {
            System.out.println("Choose to : 1.See Cards / 2.Add a Card / 3.Delete a Card / back");
            String input3 = scanner.nextLine();
            if (input3.equalsIgnoreCase("1") || input3.equalsIgnoreCase("See Cards")) {
                isValidInput3 = true;
                while (!isValidInput4) {
                    System.out.println("Choose to : 1.See ALL your Cards 2.See your Deck Cards 3.See the Cards you can add to your Deck 4.See the cards you have them , but are not in your deck / back");
                    String input4 = scanner.nextLine();
                    if (input4.equalsIgnoreCase("1") || input4.equalsIgnoreCase("See ALL your Cards")) {
                        isValidInput4 = true;
                        System.out.println(gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()  + " which sum up to " + gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroAllCards().size() + " cards ");
                        goBackToCardMenu();
                    }
                    if (input4.equalsIgnoreCase("2") || input4.equalsIgnoreCase("See your Deck Cards ")) {
                        isValidInput4 = true;
                        System.out.println(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards() + " which sum up to " + gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards().size() + " cards ");
                        goBackToCardMenu();
                    }
                    if (input4.equalsIgnoreCase("3") || input4.equalsIgnoreCase("See the Cards you can add to your Deck")) {
                        isValidInput4 = true;
                        System.out.println("the cards you can add to your deck are : \n");
                        for (Cards.card card : gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()) {
                            if (Collections.frequency(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards(),card) <= 1) {
                                System.out.println(card.toString());
                            }
                        }
                        goBackToCardMenu();
                    }
                    if (input4.equalsIgnoreCase("4") || input4.equalsIgnoreCase("See the cards you have them , but are not in your deck")) {
                        isValidInput4 = true;
                        System.out.println("the cards you can add to your deck are : \n");
                        for (Cards.card card : gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()) {
                            if (!gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards().contains(card)) {
                                System.out.println(card.toString());
                            }
                        }
                        goBackToCardMenu();
                    }
                    if(input4.equalsIgnoreCase("back")){
                        goToCardMenu();
                    }
                    else {
                        System.out.println("Wrong input!!");
                        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input  IN_LINE:162");
                    }
                }
            }
            if (input3.equalsIgnoreCase("2") || input3.equalsIgnoreCase("Add a Card")) {
                isValidInput3 = true;
                chooseTheHero();
                addCardToDeck();
                goBackToCardMenu();
            }
            if (input3.equalsIgnoreCase("3") || input3.equalsIgnoreCase("Delete a Card")) {
                isValidInput3 = true;
                chooseTheHero();
                removeCardFromDeck();
                goBackToCardMenu();
            }
            if(input3.equalsIgnoreCase("back")){
                gameCLI.getInstance().goToMenus();
            }
            else {
                System.out.println("Wrong input!!");
            }
        }
    }

    public void goBackToCardMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("go back?(y/n)");
        if(scanner.nextLine().equalsIgnoreCase("y")){
            goToCardMenu();
        }
        else{
            goBackToCardMenu();
        }
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"BACK_TO_CARD_MENU");
    }

    public static void addCardToDeck() throws IOException {
        Boolean isValid = false;
      o :  while (!isValid) {
            System.out.println("Enter the Card's name to add it to your deck : ");
            String cardName = new Scanner(System.in).nextLine();
            for (card card : gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards()) {
                if(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards().size()>= 15){
                    System.out.println("your deck is full and it has 10 cards , remove some card to be able to add cards ! ");
                    removeCardFromDeck();
                }
                if (Collections.frequency(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards(),card) <= 1 && card.getName().equalsIgnoreCase(cardName)   && (card.getHeroClass().toString().equalsIgnoreCase(gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().toString()) || card.getHeroClass().toString().equalsIgnoreCase("NEUTRAL"))) {
                    gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards().add(card);
                    gameCLI.getInstance().getCurrentPlayer().getALLPlayersCards().add(card);
                    System.out.println(cardName + "has been added to your deck successfully !");
                    gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"USER_ADDED_CARD_TO_DECK : "+ cardName );
                    break o;
                }
            }
            System.out.println("your input is invalid!! ");
          gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input for adding the card  IN_LINE:218");
        }
        jsonTofilePlayer(gameCLI.getInstance().getCurrentPlayer());
    }
    public static void removeCardFromDeck() throws IOException {
        Boolean isValid = false;
       o: while (!isValid) {
            System.out.println("Enter the Card's name to delete it from your deck");
            String cardName = new Scanner(System.in).nextLine();
            for (card card : gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards()) {
                if (card.getName().equalsIgnoreCase(cardName)) {
                    gameCLI.getInstance().getCurrentPlayer().getPlayersChoosedHero().getHeroDeckCards().remove(card);
                    System.out.println(cardName + " has been deleted from your deck successfully !");
                    gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "USER_REMOVED_CARD_FROM_DECK : " + cardName);
                    break o;
                }
            }
            System.out.println("your input is invalid!! ");
           gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO, "ERROR : invalid input for deleting the card  IN_LINE:236");
        }
        jsonTofilePlayer(gameCLI.getInstance().getCurrentPlayer());
    }

    public static ArrayList<card> getALLCardsExistingInGame() {
        ArrayList<card> arrayList = new ArrayList<>();
        File AllCards = new File("src/JSON/jsonForCards/jsonFilesForCards");
        File[] CardFiles = AllCards.listFiles();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        for (File file : CardFiles){
            FileReader fileReader = null;
            try {
                fileReader = new FileReader("src/JSON/jsonForCards/jsonFilesForCards/" + file.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            card card = gson.fromJson(fileReader, card.class);
            arrayList.add(card);
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override
    public void help() throws IOException {
        gameCLI.getInstance().getCurrentPlayer().getPlayerLOGGER().log(Level.INFO,"OPENED_HELP");
        System.out.println("Heroes : you can see game and your heroes here or change your hero :) \n  Cards : you can choose to see your cards , add or remove cards here \n back to collections menu?");
        goToCollectionsMenu();
    }

//       // ArrayList<card> arrayList = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader("ALLCardsExistingInGame.json");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Object obj = null;
//        try {
//            obj = jsonParser.parse(fileReader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        JSONArray CardsJList = (JSONArray) obj;
//        ArrayList<card> arrayList = new ArrayList<>();
//        for (Object object : CardsJList) {
//            arrayList.add((card)object);
//        }

}
