package practice.heap;

import java.util.*;

public class MedianOfAStream {

  public static List<Double> median(Iterator<Integer> it) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    List<Double> result = new ArrayList<>();
    while (it.hasNext()) {
      minHeap.offer(it.next());
      maxHeap.offer(minHeap.poll());

      if (maxHeap.size() > minHeap.size()) {
        minHeap.offer(maxHeap.poll());
      }
      result.add(
          maxHeap.size() == minHeap.size()
              ? (minHeap.peek() + maxHeap.peek()) * 0.5
              : (double) minHeap.peek());
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(median(Arrays.asList(1, 0, 3, 5, 2, 0, 1).iterator()));
  }
}
