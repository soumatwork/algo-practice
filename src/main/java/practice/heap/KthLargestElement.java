package practice.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {
  static class Entry<T extends Comparable<T>> implements Comparable<Entry<T>> {
    T value;
    Integer index;

    public Entry(T value, Integer index) {
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(Entry<T> o) {
      return value.compareTo(o.value);
    }
  }

  public static <T extends Comparable<T>> List<T> find(List<T> a, int k) {
    if (k <= 0 || a.isEmpty()) {
      return List.of();
    }

    List<T> result = new ArrayList<>();
    PriorityQueue<Entry<T>> heap = new PriorityQueue<>(16, Collections.reverseOrder());
    heap.offer(new Entry<>(a.get(0), 0));

    for (int i = 0; i < k; i++) {
      Entry<T> entry = heap.poll();
      result.add(entry.value);

      int left = 2 * entry.index + 1;
      if (left < a.size()) {
        heap.offer(new Entry<>(a.get(left), left));
      }

      int right = 2 * entry.index + 2;
      if (right < a.size()) {
        heap.offer(new Entry<>(a.get(right), right));
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(find(List.of(561, 314, 401, 28, 156, 359, 271, 11, 3), 4));
  }
}
