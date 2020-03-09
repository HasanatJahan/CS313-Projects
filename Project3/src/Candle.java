import java.util.*;
/**
 * The Candle class represents a candle with
 * height, width, price and whether the candle
 * is lit or not, along with methods that can be used to
 * modify and display the candle.
 *
 * @author Hasanat Jahan
 * @lab-section 11H Cuiyuan Wang
 * @lab-time: TueThu 3:50PM-4:40PM
 */

public class Candle {
    // Instance Variables
    private int h;
    private int w;
    private float p;
    private boolean isLit;

    //three variable constructor
    public Candle(int height, int width, float price){
        super();
        this.h=height;
        this.w=width;
        this.p=price;
        this.isLit=false;
    }

    /**
     * get and set methods for each instance variable
     * @return
     */
    //get height method
    public int getHeight(){
        return h;
    }
    //set height method
    public void setHeight(int newh){
        h=newh;
    }
    //get and set methods width
    public int getWidth(){
        return w;
    }
    public void setWidth(int newW){
        w=newW;
    }
    //get and set methods width
    public float getPrice(){
        return p;
    }
    public void setPrice(float newP){
        p=newP;
    }

    //get and set for isLit
    public boolean isLitOrNot(){
        return isLit;
    }
    public void isLitOrNot(boolean isLit){
        this.isLit= isLit;
    }

    //override toString
    @Override
    public String toString(){
        return "Height:"+ h + ", " +"Width:"+ w + ", " + "Price:$"+ p;
    }
}