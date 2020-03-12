package Player;

import java.util.Scanner;

public class Player {

    public String PlayerName;
    public String PlayerPassword;
    Boolean IsSignedin = false;
    public int PlayerCoins = 50;
    // players carts

    Scanner scanner = new Scanner(System.in);
    public void Signup(){
        boolean flagName = false;
        boolean flagPass = false;

        while (!flagName){
            try {
                System.out.println("Creat your user name: ");
                PlayerName = scanner.nextLine();
                //check if players name is legal ...
                flagName = true;
            }
            catch (Exception e1){
                System.out.println("Sorry this name is taken, Try something else..");
            }
        }
        while (!flagPass){
            try {
                System.out.println("Creat your password: ");
                PlayerPassword = scanner.nextLine();
                //check if players password is legal
                flagPass = true;
            }
            catch (Exception e2){
                System.out.println("Password should be beetwin 8-16 characters, Try again..");
            }

        }
        IsSignedin = true;

    }

    public void Signin(){
        boolean flagName = false;
        boolean flagPass = false;

        while (!flagName){
            try {
                System.out.println("Enter your user name: ");
                PlayerName = scanner.nextLine();
                //check if players name is legal and exists ...
                flagName = true;
            }
            catch (Exception e1){
                System.out.println("There isn't an account in this name , Try again..");
            }
        }
        while (!flagPass){
            try {
                System.out.println("Enter your password: ");
                PlayerPassword = scanner.nextLine();
                //check if players password is the same for the corresponding name
                flagPass = true;
            }
            catch (Exception e2){
                System.out.println("Wrong password , Try again..");
            }

        }
        IsSignedin = true;
    }

    public void deletThePlayer(){
        Scanner scanner = new Scanner(System.in);
        if(this.IsSignedin == true) {
            Boolean isvalid = false;
            while (!isvalid) {
                System.out.println("Enter your Password");
                String pass = scanner.nextLine();
                if (pass == this.PlayerPassword) {
                    isvalid = true;
                    // delte the info for this player
                    System.exit(0);
                } else {
                    System.out.println("Wrong password! ");
                }

            }
        }
        else{
                System.out.println("you have to sign in first");
            }

    }

    public void goToMenues(){
        System.out.println("which Menu do you want to go(collections/store)?");
        Scanner scanner = new Scanner(System.in);
        String MenuName = scanner.nextLine();
        Boolean isValidName = false;

        while (!isValidName) {

            switch (MenuName) {
                case "collections": {
                    isValidName = true;
                    // show all your cards
                    System.out.println();

                    break;
                }
                case "store": {
                    isValidName = true;
                    // all the cards u dony own or have sold
                    break;
                }
                default:{
                    System.out.println("invalid Menu name! Try again..");
                }

            }
        }
    }


}
