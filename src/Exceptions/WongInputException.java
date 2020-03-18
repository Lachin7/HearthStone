package Exceptions;

public class WongInputException extends Exception {
    public WongInputException (){
        super();
        System.out.println("invalid input!");
    }
}
