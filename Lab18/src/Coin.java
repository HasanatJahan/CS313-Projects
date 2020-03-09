
public abstract class Coin extends Money {
    private int value;

    public Coin(int v) {
        value = v;
    }
    public int getValue () {
        return value;
    }
    public String toString() {
        //we need to change the value here so it takes the smaller coins
        if(getValue()>=10)
            return ("$ 0."+getValue());
        else
            return ("$ 0.0"+getValue());
    }
}