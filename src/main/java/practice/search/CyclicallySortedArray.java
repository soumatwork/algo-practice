package practice.search;

import java.util.List;

public class CyclicallySortedArray {
  public static int findSmallest(List<Integer> a) {
    int left = 0, right = a.size() - 1;

    while (left < right) {
      int mid = left + ((right - left) / 2);
      if (a.get(mid) > a.get(right)) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    System.out.println(findSmallest(List.of(30, 40, 50, 60, 70)));
  }
}
