import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	   // Returns a List of all movies in the specified file (assume there is one movie per line).
	   public static ArrayList<String> getList(String filename) {
	      ArrayList<String> list = new ArrayList<>();
	      try (Scanner in = new Scanner(new FileReader(filename))) {
	         while (in.hasNextLine()) {
	            String line = in.nextLine();
	            list.add(line);
	         }
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      }
	      return list;
	   }
	   public static void main(String[] args) {
		      ArrayList<String> list1 = getList("imdb.txt");
		      ArrayList<String> list2 = getList("sight_and_sound.txt");
		      ArrayList<String> list3 = getList("3_lists.txt");

            //Sort lists
            Collections.sort(list1); 
            Collections.sort(list2); 
            Collections.sort(list3);

            //Note: these are my tests
		   System.out.println("My test" + setAndMaps.groupByNumChars(list3));


		   //Note: ends


		      System.out.println("***\nintersection\n***");
		      System.out.println(setAndMaps.intersection(list1, list2));

		      System.out.println("***\nfrequent\n***");
		      System.out.println(setAndMaps.frequent(list3, 3));

		      System.out.println("***\ngroupByNumChars\n***");
		      System.out.println(setAndMaps.groupByNumChars(list2));
	   }
}