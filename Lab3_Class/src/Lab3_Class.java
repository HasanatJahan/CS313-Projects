public class Lab3_Class {
    public static void main(String [] args){
        float fahrenheit, centigrade;
        //in java you have to specify floats- otherwise they're doubles
        fahrenheit = 98.6f;
        centigrade = 5/9f*(fahrenheit-32f);
        System.out.println("Centigrade is "+ centigrade);

        System.out.println("This output is for the for loop");
        for(float i=0; i<41; i+=5){
            centigrade= 5/9f*(i-32);
            System.out.println(i+" degree Fahrenheit is "+centigrade+" degree Centrigate");
        }

        System.out.println("This output is for the while loop");
        float i=0;
        while(i<41){
            centigrade= 5/9f*(i-32);
            System.out.println(i+" degree Fahrenheit is "+centigrade+" degree Centrigate");
            i+=5;
        }
    }
}
