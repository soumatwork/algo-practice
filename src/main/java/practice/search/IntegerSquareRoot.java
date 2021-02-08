package practice.search;

public class IntegerSquareRoot {
  public static int sqrt(int k) {
    int left = 0, right = k;

    while (left <= right) {
      int mid = left + ((right - left) / 2);
      int midSquared = mid * mid;
      if (midSquared > k) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left - 1;
  }

  public static void main(String[] args) {
    System.out.println(sqrt(9));
  }
}
