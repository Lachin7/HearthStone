package Player;

import java.util.Scanner;

public class Player {

    public String PlayerName;
    public String PlayerPassword;
    public int PlayerCoins = 50;
    // players carts

    Scanner scanner = new Scanner(System.in);
    public void SignIn(){
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

    }

    public void LogIn(){
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
    }

    public void Logout(){
        PlayerName = null;
        PlayerPassword = null;
    }
}
