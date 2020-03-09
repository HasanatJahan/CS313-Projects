
public class Bill extends Money{
    private int dollars;

    public Bill (int d) {
        if(d!=1 && d!=5 && d!=10 && d!=20 && d!=50 && d!=100){
            throw new IllegalArgumentException("Illegal bill value " + d);
        }
        dollars = d;
    }
    public int getValue () {
        return dollars;
    }

}