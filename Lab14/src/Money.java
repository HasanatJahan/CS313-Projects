
public class Money implements Comparable<Money> {

    private int dollars, cents;

    /**
     * Constructor makes a call to {@link #Money(int, int)}
     * with (0,0) as parameters
     */
    public Money() {
        //this is calling the lower constructor from the upper constructor
        this(0,0);
        //same as
        //dollars=0;
        //cents=0;
    }

    public Money(int dollars, int cents) {
        // TODO Fill this in
        // Hint: Use integer division by 100 to get dollars from cents
        // and use modulus to get cent values between 0 and 100 (mod by 100)
        this.dollars=(this.dollars+dollars)+ (cents+this.cents)/100;
        this.cents=(this.cents+cents)%100;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // LAB 14
        Money m1 = new Money(), m2= new Money(6,5);
        System.out.println(m1.getCents());
        System.out.println(m2.getDollars());
        System.out.println(m2);
        System.out.println(m1.compareTo(m2));
        System.out.println(m1.equals(m2));

        // LAB 15
        m1 = new Money(4,87);
        m2 = new Money(5,243);

        m1.add(m2);

        System.out.println("This is m1 after add: ");
        System.out.println(m1.toString());

    }

    public void add(Money other) {
        // TODO Fill this in
        // Hint: Add the cents first, check if you surpass 100 (check hint from 2-arg constructor),
        // then add dollars
        this.dollars= (this.dollars+ other.dollars)+ (this.cents+other.cents)/100;
        this.cents= (this.cents+ other.cents)%100;
    }

    @Override
    public int compareTo(Money other) {
        // TODO Fill this in
        /*
         * Steps:
         * 1) Test the dollars in both first
         * 2) If dollar values are equal, test
         * cents in both
         * 3) If both dollars and cents are equal return 0
         *
         * Hint: compareTo can be viewed as a subtraction operation
         */
        if(this.dollars<other.dollars){
            return -1;
        }
        else if(this.dollars>other.dollars){
            return 1;
        }else{
            if(this.cents<other.cents){
                return -1;
            }
            if (this.cents>other.cents){
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        // TODO Fill this in
        /*
         * Steps:
         * 1) Test if other is null
         * 2) Test if other is of type Money
         * 3) If the above tests pass, then cast other into
         * type Money
         * 4) Compare dollar and cents in both.
         * If equal return true, otherwise return false
         */
        //this checks if they are the same object
        if (this == other) return true;
        //here the equals is being used from the super class- we are checking class typw
        if(other!=null && this.getClass().equals(other.getClass())) {
            // Start from step 3
            //we are casting the object as a money type
            if(this.dollars ==((Money)other).dollars){
                if(this.cents==((Money)other).cents){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String c;
        if(cents<10) {
            c = "0" + cents;
        } else {
            c = "" + cents;
        }
        return "$ " + dollars + "." + c;
    }

    /**
     * Get methods
     */

    public int getCents() {
        return cents;
    }

    public int getDollars() {
        return dollars;
    }

    /**
     * Set Methods
     */
    public void setDollars(int newDollar){
        this.dollars= newDollar;
    }

    public void setCents(int newCents){
        if(newCents>100)
            newCents= newCents%100;
        this.cents= newCents;
    }



}