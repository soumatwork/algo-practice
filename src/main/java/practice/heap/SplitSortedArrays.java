package practice.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SplitSortedArrays {

  public enum Order {
    INCREASING,
    DECREASING
  }

  public static <T extends Comparable<T>> List<List<T>> split(List<T> a) {
    List<List<T>> result = new ArrayList<>();
    Order currentOrder = Order.INCREASING;
    int startIndex = 0;
    for (int i = 1; i <= a.size(); i++) {
      if (i == a.size()
          || (a.get(i - 1).compareTo(a.get(i)) < 0 && currentOrder == Order.DECREASING)
          || (a.get(i - 1).compareTo(a.get(i)) >= 0 && currentOrder == Order.INCREASING)) {

        List<T> subList = a.subList(startIndex, i);
        if (currentOrder == Order.DECREASING) Collections.reverse(subList);
        result.add(subList);
        startIndex = i;
        currentOrder = currentOrder == Order.INCREASING ? Order.DECREASING : Order.INCREASING;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(split(Arrays.asList(1, 2, 10, 11, 8, 3, 4, 5)));
  }
}
