package Exceptions;

public class PlayerAlreadyExistsException extends Exception {
    public PlayerAlreadyExistsException(){
        super();
    }
    PlayerAlreadyExistsException(String message){
        super(message);
    }
}
