public class StatePair <Type1 extends Comparable<Type1>, Type2 extends Comparable<Type2>> {
    private Type1 value1;
    private Type2 value2;

    // TODO: Define a constructor, mutators, and accessors
    //       for StatePair
   public StatePair(Type1 newValue1, Type2 newValue2){
        value1 = newValue1;
        value2 = newValue2;
    }

    // mutator
    public void setKey(Type1 userVal){
       value1 = userVal;
    }

    public void setVal(Type2 userVal){
       value2 = userVal;
    }

    // accessor
    public Type1 getKey(){
       return value1;
    }

    public Type2 getVal(){
       return value2;
    }

    // TODO: Define printInfo() method
    public void printInfo(){
        System.out.println(value1 + ": " + value2);
    }

}