public class Demo {
    public static void main (String [] args){
        Money m1 = new Money();
        Money m2 = new Money(6,5);
        System.out.println(m1.getCents());
        System.out.println(m2.getDollars());
        System.out.println(m2);
        System.out.println(m1.compareTo(m2));
        System.out.println(m1.equals(m2));
    }
}
