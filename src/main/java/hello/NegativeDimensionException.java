package hello;

public class NegativeDimensionException extends Exception{
    static private String msg ="size can't be less or equal then 0";

    @Override
    public String toString() {
        return msg;
    }
}
