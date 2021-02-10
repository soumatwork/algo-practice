package practice.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class KthLargest {

  // 1,2,3,4,5
  // left =0, right = 4
  //
  public static Integer kthLargest(List<Integer> a, int k) {
    int left = 0, right = a.size() - 1;
    Random r = new Random(0);

    while (left <= right) {
      int pivot = r.nextInt(right - left + 1) + 1;
      int newPivot = newPivot(left, right, pivot, a);
      if (newPivot > k - 1) {
        right = newPivot - 1;
      } else if (newPivot == k - 1) {
        return a.get(newPivot);
      } else {
        left = newPivot + 1;
      }
    }

    return -1;
  }

  // 1,2,3,4,5
  private static int newPivot(int left, int right, int pivot, List<Integer> a) {
    int newPivot = left;
    Integer pivotValue = a.get(pivot);
    Collections.swap(a, pivot, right);

    for (int i = left; i < right; i++) {
      if (a.get(i) < pivotValue) {
        Collections.swap(a, i, newPivot++);
      }
    }

    Collections.swap(a, right, newPivot);
    return newPivot;
  }

  public static void main(String[] args) {
    System.out.println(kthLargest(Arrays.asList(8, 2, 3, 4, 5), 2));
  }
}
