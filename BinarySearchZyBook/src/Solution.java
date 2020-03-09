import java.util.Scanner;
import java.util.ArrayList;

//I used the resource : https://leetcode.com/problems/binary-search/

public class Solution {
    public int getIndex(int [] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        //while left does not overlap right
        while(left < right){
            mid = (left + right) / 2;
            //if it's the mid number
            if(nums[mid] == target) return mid;
            //if target is less than mid, then go left
            if(target < nums[mid]){
                right = mid - 1;
            }
            //if target is greater than mid then shift left
            if(target > nums[mid]){
                left = mid + 1;
            }
        }//while

        //if the search does not find the value, return the mid
        if(target < nums[mid]){
            return left;
        }else if(target > nums[right]){
            return right + 1;
        }else{
            return right;
        }

    } //getIndex

    //Sample main to run tests
    public static void main(String args[]) {
        //Custom set variable
        /*
         * You can set this value to an item within the array
         * Set to 0 by default
         */
        int target = 13;
        /*
         *
         */
        //Variables
        Scanner scnr = new Scanner(System.in);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int [] arr;
        Solution test = new Solution();
        //Remaining values will be added to the array
        while(scnr.hasNext()){
            arrList.add(scnr.nextInt());
        }
        //Instance primitive array to size of ArrayList
        arr = new int[arrList.size()];
        //Copy elements from ArrayList to primitive array
        for(int i = 0; i < arr.length; i++)
            arr[i] = arrList.get(i);
        //Test values
        int out = test.getIndex(arr,target);
        System.out.println(out);
    }
}