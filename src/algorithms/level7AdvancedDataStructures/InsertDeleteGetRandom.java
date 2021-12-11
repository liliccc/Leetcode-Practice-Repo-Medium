package algorithms.level7AdvancedDataStructures;

import java.util.*;

public class InsertDeleteGetRandom {

    private List<Integer> valueList;
    private Map<Integer, Integer> keyToIndex;
    private Random rand;


    public InsertDeleteGetRandom() {
        this.valueList = new ArrayList<>();
        this.keyToIndex = new HashMap<>();
        this.rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (keyToIndex.containsKey(val)) {
            return false;
        }
        valueList.add(val);
        keyToIndex.put(val, valueList.size() - 1);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!keyToIndex.containsKey(val)) {
            return false;
        }
        int valueIndex = keyToIndex.get(val);
        int lastValueInList = valueList.get(valueList.size() - 1);

        valueList.set(valueIndex, lastValueInList);
        keyToIndex.put(lastValueInList, valueIndex);

        valueList.remove(valueList.size() - 1);
        keyToIndex.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        return valueList.get(rand.nextInt(valueList.size()));
    }
}
