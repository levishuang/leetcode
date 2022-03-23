package round1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/17 15:17
 */

public class LRUCache {
    HashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, (float) 0.7, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > capacity;
            }
        };

    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
    public void show(){
        for(int key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
    }
}
