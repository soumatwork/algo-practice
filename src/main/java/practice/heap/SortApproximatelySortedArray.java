package practice.heap;

import java.util.*;

public class SortApproximatelySortedArray {

  public static <T> List<T> sort(Iterator<T> a, int k) {
    List<T> result = new ArrayList<>();
    PriorityQueue<T> heap = new PriorityQueue<>();

    for (int i = 0; i < k && a.hasNext(); i++) {
      heap.offer(a.next());
    }

    while (a.hasNext()) {
      heap.offer(a.next());
      result.add(heap.poll());
    }

    while (!heap.isEmpty()) {
      result.add(heap.poll());
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(sort(Arrays.asList(-3, 1, 2, 6, 4, 5, 8).iterator(), 2));
  }
}
