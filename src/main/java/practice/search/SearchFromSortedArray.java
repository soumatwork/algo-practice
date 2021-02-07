package practice.search;

import java.util.List;

public class SearchFromSortedArray {
  public static <T extends Comparable<T>> int find(List<T> a, T k) {
    int result = -1;
    int left = 0, right = a.size() - 1;

    while (left <= right) {
      int mid = left + ((right - left) / 2);
      if (a.get(mid).compareTo(k) > 0) {
        right = mid - 1;
      } else if (a.get(mid).compareTo(k) == 0) {
        return mid;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(find(List.of(10, 20, 30, 40, 50), 50));
  }
}
