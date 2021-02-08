package practice.search.twod;

import java.util.List;

public class Sorted2D {
  public static <T extends Comparable<T>> boolean find(List<List<T>> a, T k) {
    int row = 0, col = a.get(0).size() - 1;

    while (row < a.size() && col >= 0) {
      if (a.get(row).get(col).compareTo(k) > 0) {
        col--;
      } else if (a.get(row).get(col).compareTo(k) < 0) {
        row++;
      } else {
        return false;
      }
    }
    return false;
  }
}
