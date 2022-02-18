package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> indexMap;
    ArrayList<Integer> valueList;
    Random rand = new Random();


    public RandomizedSet() {
        indexMap = new HashMap<>();
        valueList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, valueList.size());
        valueList.add(valueList.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int last = valueList.get(valueList.size() - 1);
        int index = indexMap.get(val);
        valueList.set(index, last);
        indexMap.put(last, index);

        valueList.remove(valueList.size() - 1);
        indexMap.remove(index);
        return true;
    }

    public int getRandom() {
        return valueList.get(rand.nextInt(valueList.size() + 1));
    }

    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(3);
        boolean param_2 = obj.remove(2);
        boolean param_4 = obj.remove(1);
        int param_3 = obj.getRandom();
        System.err.println("");
    }
}
