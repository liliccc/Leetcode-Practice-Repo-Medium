package com.company.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumIII {

    public HashMap<Integer, Integer> map;
    public ArrayList<Integer> list;

    public TwoSumIII () {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        }
        else {
            map.put(number, 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int key : map.keySet()) {
            int diff = value - key;
            if ((key == diff && map.get(key) > 1) || (key != diff && map.get(diff) != null)) {
                return true;
            }
        }
        return false;
    }
}

class Main {

    public static void main(String[] args) {
        TwoSumIII twoSumIII = new TwoSumIII();
        twoSumIII.add(1);
        twoSumIII.add(3);
        twoSumIII.add(5);
        System.out.println(twoSumIII.find(7));

    }

}