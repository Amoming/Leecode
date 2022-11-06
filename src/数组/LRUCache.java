package 数组;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    // 双向链表存储结点进入顺序
    Map<Integer, Integer> LRU = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(LRU.containsKey(key)){
            //将此key作为刚刚访问的key
            makeNew(key);
            return LRU.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        // LRU存在
        if(LRU.containsKey(key)){
            LRU.put(key, value);
            makeNew(key);
            return;
        }
        //LRU溢出
        if(LRU.size() == capacity){
            Integer removeKey = LRU.entrySet().iterator().next().getKey();
            LRU.remove(removeKey);
        }
        //LRU正常插入
        LRU.put(key, value);
    }

    public void makeNew(int key){
        Integer value = LRU.get(key);
        LRU.remove(key);
        LRU.put(key, value);
    }
}
