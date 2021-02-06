package practice.heap;

import java.util.*;
import java.util.stream.Collectors;

public class MergeSortedArrays {
  static class A<T> {
    T value;
    Integer index;

    public A(T value, Integer index) {
      this.value = value;
      this.index = index;
    }
  }

  public static <T extends Comparable<T>> List<T> merge(List<List<T>> arrays) {
    List<T> result = new LinkedList<>();
    PriorityQueue<A<T>> heap =
        new PriorityQueue<>(arrays.size(), Comparator.comparing(o -> o.value));

    List<Iterator<T>> it = arrays.stream().map(List::iterator).collect(Collectors.toList());

    for (int i = 0; i < arrays.size(); i++) {
      if (it.get(i).hasNext()) {
        heap.offer(new A<>(it.get(i).next(), i));
      }
    }

    while (!heap.isEmpty()) {
      A<T> a = heap.poll();
      result.add(a.value);

      if (it.get(a.index).hasNext()) {
        heap.offer(new A<>(it.get(a.index).next(), a.index));
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(merge(List.of(List.of(3, 8, 10), List.of(4, 9), List.of(5, 6, 7))));
  }
}
