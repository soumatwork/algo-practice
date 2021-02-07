package practice.search;

import java.util.List;

public class FindElementEqualToIndex {
  public static int find(List<Integer> a) {
    int result = -1;
    int left = 0, right = a.size() - 1;

    while (left <= right) {
      int mid = left + ((right - left) / 2);
      if (a.get(mid) > mid) {
        right = mid - 1;
      } else if (a.get(mid) == mid) {
        return mid;
      } else {
        left = mid + 1;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(find(List.of(-1, 0, 2, 3, 5)));
  }
}
