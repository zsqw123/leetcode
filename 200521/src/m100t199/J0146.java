package m100t199;

import java.util.LinkedHashMap;
import java.util.Map;

class J0416{
    class LRUCache {
        class LRU extends LinkedHashMap<Integer,Integer>{
            int max;
            LRU(int size){
                super(size,0.75f,true);
                max=size;
            }
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size()>max;
            }
        }

        LRUCache.LRU lru;
        public LRUCache(int capacity) {
            lru=new LRUCache.LRU(capacity);
        }

        public int get(int key) {
            return lru.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            lru.put(key,value);
        }
    }
}