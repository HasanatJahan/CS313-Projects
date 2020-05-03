import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BSTMap<Integer, Integer> bt1 = new BSTMap<>(), bt2 = new BSTMap<>();
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
//        if (scnr.hasNextLine()) {
//            try {
//                String[] in1 = scnr.nextLine().split("\\s");
//                String[] in2 = scnr.nextLine().split("\\s");
//                for (String s : in1)
//                    bt1.put(Integer.parseInt(s), rand.nextInt());
//                for (String s : in2)
//                    bt2.put(Integer.parseInt(s), rand.nextInt());
//            } catch (java.util.NoSuchElementException nse) {
//                System.out.println("*******Warning*******\n  No input given for\n   one or both BSTs\n*********************");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                return;
//            }
//        } else {
            int testArr[] = {3, 2, 5, 4, 6, 1, 9, 2, 4, 2};
            for (int i : testArr) {
                bt1.put(i, rand.nextInt(100));
                bt2.put(i, rand.nextInt(100));
            }
            bt1.put(1, rand.nextInt(100));
            bt2.put(1, rand.nextInt(100));
//        }
        System.out.println("bt1 contains 5: " + bt1.containsKey(5));
        System.out.println("bt1 maximum is: " + bt1.maximum(bt1.root));
        System.out.println("bt1 height is: " + bt1.height(bt1.root));
        System.out.println("\nbt2 contains 5: " + bt2.containsKey(5));
        System.out.println("bt2 maximum is: " + bt2.maximum(bt2.root));
        System.out.println("bt2 height is: " + bt2.height(bt2.root));
        System.out.println("\nbt1 == bt2: " + bt2.sameTree(bt1.root, bt2.root));
        System.out.println("bt1 is proper BST: " + bt1.isBST(bt1.root));
        System.out.println("bt2 is proper BST: " + bt2.isBST(bt2.root));
        System.out.println("\nbt1 levelDeque: " + bt1.levelDeque(bt1.root));
        bt1.root = bt1.rotateLeft(bt1.root);
        System.out.println("bt1 rotated at left child of root");
        System.out.println("bt1 is proper BST: " + bt1.isBST(bt1.root));
        System.out.println("bt1 levelDeque: " + bt1.levelDeque(bt1.root));
    }
}
