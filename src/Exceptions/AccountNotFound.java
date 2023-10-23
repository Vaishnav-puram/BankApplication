package Exceptions;

public class AccountNotFound extends Exception{
    private String msg;
    public AccountNotFound(String msg){
        this.msg=msg;
    }
}
