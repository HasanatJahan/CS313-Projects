import java.util.Scanner;

public class Utility {
    public static void main(String[] args) {
        int arr[] = {-1, 5, 1, 1, 4, -3, 2, 1, 1, -4};
        int number = 1;
        Solution<Integer> counter = new Solution<Integer>();
        LinkedStack<Integer> s = new LinkedStack<>();
        Scanner scnr = new Scanner(System.in);
        //Takes in first value to count
//        if(scnr.hasNext()){
//            number = scnr.nextInt();
//            //Writes to list if input exists
//            if(scnr.hasNext())
//                while(scnr.hasNext())
//                    s.push(scnr.nextInt());
//        }
        //Else, add default values
//        else
            for(int i : arr)
                s.push(i);

        System.out.println(counter.count(s, number));
    }
}