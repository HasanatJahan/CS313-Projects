public class HelloYourName {
    public static void main(String args[]){
        if(args.length!=2){
            System.out.println("First and Last name needed");
            System.exit(42);
        }
        System.out.println("Hello There "+args[0]+ " "+ args[1]);
        System.exit(42);
    }
}
