package practice.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用Java自带的LinkedHashMap实现LRU缓存
 */
public class UseLinkedHashMap {
    public static void main(String[] args) {
        UserLinkedHashMap<Integer, String> LRUCache = new UserLinkedHashMap<>(4);
        LRUCache.put(1, "One");
        LRUCache.put(2, "two");
        LRUCache.put(3, "three");
        LRUCache.put(4, "four");
        LRUCache.put(2, "two");
        LRUCache.put(3, "three");
        Iterator<Map.Entry<Integer, String>> it = LRUCache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> item = it.next();
            System.out.println("key: " + item.getKey() + " / value: " + item.getValue());
        }
    }
}

class UserLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public UserLinkedHashMap(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.removeEldestEntry(eldest);
    }
}