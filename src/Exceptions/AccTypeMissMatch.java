package Exceptions;

public class AccTypeMissMatch extends Exception{
    private String msg;
    public AccTypeMissMatch(String msg){
        this.msg=msg;
    }
}
