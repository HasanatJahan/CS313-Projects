import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PlantArrayListExample {

    // TODO: Define a PrintArrayList method that prints an ArrayList of plant (or flower) objects
    public static void PrintArrayList(ArrayList<Plant> array){
        for(Plant elem : array){
            elem.printInfo();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input;
        // TODO: Declare an ArrayList called myGarden that can hold object of type plant
        ArrayList<Plant> myGarden = new ArrayList<Plant>();
        // TODO: Declare variables - plantName, plantCost, colorOfFlowers, isAnnual
        String plantName, plantCost;
        String colorOfFlowers;
        boolean isAnnual;

        input = scnr.nextLine();

//        input = scnr.next();
        while(!input.equals("-1")){
            // TODO: Check if input is a plant or flower
            //       Store as a plant object or flower object
            //       Add to the ArrayList myGarden


            StringTokenizer userString = new StringTokenizer(input, " ");



            String firstWord = userString.nextToken();
            //if it's a flower then create a flower object
            if(firstWord.equalsIgnoreCase("flower")){
                //create a flower object
                Flower plant = new Flower();

                plantName = userString.nextToken();
                plant.setPlantName(plantName);

                plantCost = userString.nextToken();
                plant.setPlantCost(plantCost);

                isAnnual = Boolean.parseBoolean(userString.nextToken());
                plant.setPlantType(isAnnual);

                colorOfFlowers = userString.nextToken();
                plant.setColorOfFlowers(colorOfFlowers);

                myGarden.add(plant);

            }else{
                //create a plant object
                Plant plant = new Plant();

                plantName = userString.nextToken();
                plant.setPlantName(plantName);


                plantCost = userString.nextToken();
                plant.setPlantCost(plantCost);

                myGarden.add(plant);
            }


            //goes to the next line
//            input = scnr.next();
            input = scnr.nextLine();
        } // while

        // TODO: Call the method PrintArrayList to print myGarden
        PrintArrayList(myGarden);
    }
}
