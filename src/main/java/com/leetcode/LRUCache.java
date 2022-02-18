package com.leetcode;

import java.util.LinkedHashMap;

public class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!linkedHashMap.containsKey(key)) {
            return -1;

        }

        makeRecently(key);
        return linkedHashMap.get(key);
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.put(key, value);
            makeRecently(key);
            return;
        }
        if (linkedHashMap.size() > capacity) {
            int oldest = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(oldest);
        }
        linkedHashMap.put(key, value);

    }

    private void makeRecently(int key) {
        int val = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key, val);

    }

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(2);
        lruCache.put(3,3);
    }
}
