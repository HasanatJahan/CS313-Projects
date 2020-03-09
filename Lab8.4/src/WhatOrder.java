import java.util.Scanner;

// Check the order of the input: return -1 for ascending,
// 0 for neither, 1 for descending

public class WhatOrder {
    // TODO: Define a generic method called checkOrder() that
    //       takes in four variables of generic type as arguments.
    //       The return type of the method is integer
    public static <Type extends Comparable<Type>> int checkOrder (Type a, Type b, Type c, Type d){
        int result = 0;
        if( a.compareTo(b) >= 1 && b.compareTo(c) >= 1 && c.compareTo(d) >= 1 ){
            result = -1;
        }
        else if( d.compareTo(c) >= 1 && c.compareTo(b) >=1 && b.compareTo(a) >= 1){
            result = 1;
        }

        return result;
    }



    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Check order of four strings
        System.out.println("Order: " + checkOrder(scnr.next(), scnr.next(), scnr.next(), scnr.next()));

        // Check order of four doubles
        System.out.println("Order: " + checkOrder(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble()));
    }
}
