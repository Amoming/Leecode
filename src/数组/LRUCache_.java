package 数组;

import java.util.HashMap;

public class LRUCache_ {
    private HashMap<Integer, Node> map;

    private DoubleList cache;

    private int cap;

    public LRUCache_(int cap) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.cap = cap;
    }

    private void makeRecently(int key){
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(int key, int value){
        Node x = new Node(key, value);
        cache.addLast(x);
        map.put(key, x);
    }

    private void deleteKey(int key){
        Node node = map.get(key);
        map.remove(key);
        cache.remove(node);
    }

    private void removeLeastRecently(){
        Node node = cache.removeFirst();
        map.remove(node.key);
    }


    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        makeRecently(key);
        return node.value;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if(cap == cache.size()){
            removeLeastRecently();
        }
        addRecently(key, value);
    }
}
