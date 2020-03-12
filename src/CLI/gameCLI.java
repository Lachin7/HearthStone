package CLI;

import Player.Player;

import java.util.Scanner;

public class gameCLI {

    public void startTheApp(){
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        System.out.println("already have an account?(y/n)");
        Boolean isValidInput = false;
        while (!isValidInput){
            switch (scanner.nextLine()){
                case "Y":
                    player.Signin();
                    isValidInput = true;
                    break;

                case "N":
                    player.Signup();
                    isValidInput = true;
                    break;

                case "exit":
                    System.exit(0);
                    break;

                case "exit -a":
                    // ??
            }

        }

    }

    public void deletThePlayer(){
        //signin delete player password
    }




}
