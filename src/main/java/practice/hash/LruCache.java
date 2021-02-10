package practice.hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {
  LinkedHashMap<Integer, Integer> cache;

  public LruCache(int capacity) {
    cache =
        new LinkedHashMap<>(capacity) {
          @Override
          protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
          }
        };
  }

  public Integer lookup(Integer isbn) {
    return cache.getOrDefault(isbn, -1);
  }

  public void create(Integer isbn, Integer price) {
    cache.putIfAbsent(isbn, price);
  }

  public Boolean erase(Integer isbn) {
    return cache.remove(isbn) != null;
  }
}
