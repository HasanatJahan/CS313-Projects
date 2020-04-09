import java.util.*;


public class WordSet<K extends Comparable<K>, V> implements Counter<K, V> {
    private Map <K, Integer> countMap = new HashMap<K, Integer>();
    private Map <K, V> map;
    private HashSet<V> allValSet = new HashSet<>();

    //constructor to create a new HashSet
    public WordSet(){
        map = new HashMap<>();
    }

    //creating an instance of the Map library with strings so it is compatible with JSON
    public String get(K word) {
        V keyVal =  map.get(word);
        //this should have the count followed by the paired values
        String getOutcome =countMap.get(word).toString() + "," + keyVal;
        return getOutcome;
    }

    // this should return the count of the words associated with a set
    public int getCount(K word) {
        return countMap.get(word);
    }

    // this method returns the keySet of the map
    public Set<K> keySet() {
        return map.keySet();
    }

    //this should put the value and key into the map
    public void put(K keyWord, V word) {
        //here create a list if there is more than one instance of a keyWord
        // if the keyword has already been entered
        if(map.containsKey(keyWord)) {
            V keyVal = map.get(keyWord);
            //if the key has no value
            if (keyVal == null) {
                map.put(keyWord, word);
                allValSet.add(word);
            }
            //otherwise concatenate it with old values
            else {
                // the value and word is an instance of a string
                if (keyVal instanceof String && word instanceof String) {
                    //if the word has not been previously added in then add it in
                    if (!allValSet.contains(word)) {
                        //keyVal converted to a String
                        String val = (String) keyVal;
                        val += "," + word;
                        //some dumb conversion so this works
                        V convertedVal = (V) val;
                        map.put(keyWord, convertedVal);
                        allValSet.add(word);
                    }
                }
            }
        }
        //if it does not contain keyWord
        else{
            map.put(keyWord, word);
            allValSet.add(word);
        }

        //now to clarify the count for each object input
        Integer keyCount = countMap.get(keyWord);
        if(keyCount == null){
            countMap.put(keyWord, 1);
        }else{
            countMap.put(keyWord, keyCount + 1);
        }

    }
}