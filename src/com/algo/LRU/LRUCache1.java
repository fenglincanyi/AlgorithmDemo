package com.algo.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 快速实现方法：LinkedHashMap
 */
public class LRUCache1 {
    private int capacity;
    private Map<Integer, Integer> cache;
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            // 定义put后的移除规则，大于容量就删除eldest
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        cache.put(key, value);
    }
}