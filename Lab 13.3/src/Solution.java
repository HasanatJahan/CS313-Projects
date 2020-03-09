import java.util.Scanner;
import java.util.ArrayList;

//used site: https://www.geeksforgeeks.org/merge-two-sorted-arrays/ for guide
public class Solution {
    public void merge(int [] nums1, int m, int [] nums2, int n){

        //first copy over all the values from num1 into temporary array
        int [] temp = new int[m];
        for(int k = 0; k < m; k++){
            temp[k] = nums1[k];
        }

        int i = 0, j = 0, l = 0;

        // traverse through both the arrays
        while(i < m && j < n ){
            //compare the values from temp and nums2
            if(temp[i] < nums2[j]){
                //advance the iterator for nums1
                nums1[l++] = temp[i++];
            }else{
                nums1[l++] = nums2[j++];
            }
        }//while

        //now copy over any remaining from each array
        while(i < m){
            nums1[l++] = temp[i++];
        }

        while( j < n ){
            nums1[l++] = nums2[j++];
        }


    } //merge method

    public static void main(String [] args) {
        //Variables
        Scanner scnr = new Scanner(System.in);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int [] arr1, arr2;
        int split = 0;
        Solution test = new Solution();
        //Remaining values will be added to the array
        while(scnr.hasNext()){
            arrList.add(scnr.nextInt());
            //Get position to mark end of arr1 and beginning of arr2
            if(arrList.size() >= 2 && arrList.get(arrList.size()-1) <= arrList.get(arrList.size()-2))
                split = arrList.size()-1;
        }
        //Instance primitive array to size of ArrayList
        arr1 = new int[arrList.size()];
        arr2 = new int[arrList.size()-(split)];
        //Copy elements from ArrayList to primitive array
        for(int i = 0; i < (split); i++)
            arr1[i] = arrList.get(i);
        for(int i = 0; i < arrList.size()-(split); i++)
            arr2[i] = arrList.get(split+i);
        //Test values
        test.merge(arr1,split,arr2,arrList.size()-(split));
        //Prints elements in arr1 after merge
        for(int i : arr1)
            System.out.println(i);
    }
}