import java.util.*;

public class setAndMaps {

   // Prints all movies that occur in both lists.
   public static String intersection(List<String> list1, List<String> list2) {
      //this is adding all the items in list 1 to the hashset
      Set<String> movieList1 = new HashSet<>(list1);
      //adding elems from list 2 in the hashset, this will later become the
      Set<String> movieList2 = new HashSet<>(list2);
      Set<String> intersection = new HashSet<>();

      if(movieList1.size() < movieList2.size() ){
         intersection = movieList2;
         intersection.retainAll(movieList1);
      }else{
         intersection = movieList1;
         intersection.retainAll(movieList2);
      }

      //create an arraylist to hold matching values
      ArrayList<String> matchingVals = new ArrayList<>();
      for (String elem : intersection) {
         matchingVals.add(elem);
      }
      Collections.sort(matchingVals); //nlogn
      String result = "";
      for (String elem : matchingVals) {
         result = result + elem;
         result = result + "\n";
      }
      return result;
   } //intersection method

   // Prints all movies in the list that occur at least k times
   public static String frequent(List<String> list, int k) { //The expected runtime must be O(nlogn) where n is the total number of movies in the list
      // create a map to hold the values of movie name and count
      Map<String, Integer> movieTMap = new TreeMap<String, Integer>();
      for (String elem : list) {
         Integer num = movieTMap.get(elem);
         if (num == null) movieTMap.put(elem, 1);
         else movieTMap.put(elem, num + 1);
      }
      //using a for each loop with a map
      String result = "";
      for (Map.Entry<String, Integer> entry : movieTMap.entrySet()) {
         // if the values are the same then add to result
         if (entry.getValue() >= k) {
            result = result + entry.getKey() + "(" + entry.getValue() + ")";
            result = result + "\n";
         }
      }
      return result;
   }

   // Prints all movies in the list, grouped by number of characters.
   // All movies with the same number of characters are printed on the same line.
   //Source: https://www.quora.com/How-do-you-add-an-element-to-an-arraylist-thats-in-a-hashmap
   public static String groupByNumChars(List<String> list) {

      //create a map to hold the count and the list together
      Map<Integer, List<String>> movieMap = new TreeMap<Integer, List<String>>();
      // for each elem in the list, count the num of characters
      for (String elem : list) {
         int count = 0;
         for (int i = 0; i < elem.length(); i++) {
            count++;
         }

         List<String> movieNames = movieMap.get(count);
         // if list does not exist create it
         if (movieNames == null) {
            movieNames = new ArrayList<String>();
            movieNames.add(elem);
            movieMap.put(count, movieNames);
         }
         // if there is a list
         else {
            if (!movieNames.contains(elem)) movieNames.add(elem);
         }
      }//for to populate the treemap

      String result = "";
      for (Map.Entry<Integer, List<String>> entry : movieMap.entrySet()) {
         ArrayList<String> temp = (ArrayList<String>) entry.getValue();
         Collections.sort(temp);
         result = result + temp + "\n";
      }
      return result;

   } //groupNumByChars

}