package practice.search;

import java.util.List;

public class SimultaneousMinMax {

  static class MinMax {
    int min;
    int max;

    public MinMax(int min, int max) {
      this.min = min;
      this.max = max;
    }

    public static MinMax minMax(int a, int b) {
      return a < b ? new MinMax(a, b) : new MinMax(b, a);
    }

    @Override
    public String toString() {
      return "MinMax{" + "min=" + min + ", max=" + max + '}';
    }
  }

  public static MinMax minMax(List<Integer> a) {
    if (a.isEmpty()) {
      return new MinMax(-1, -1);
    }
    if (a.size() == 1) {
      return new MinMax(a.get(0), a.get(0));
    }

    MinMax global = MinMax.minMax(a.get(0), a.get(1));
    for (int i = 2; i + 1 < a.size(); i = i + 2) {
      MinMax local = MinMax.minMax(a.get(i), a.get(i + 1));

      global = new MinMax(Math.min(global.min, local.min), Math.max(global.max, local.max));
    }
    if (a.size() % 2 != 0) {
      global =
          new MinMax(
              Math.min(global.min, a.get(a.size() - 1)), Math.max(global.max, a.get(a.size() - 1)));
    }

    return global;
  }

  public static void main(String[] args) {
    System.out.println(minMax(List.of(3, 2, 5, 1, 2, 4)));
  }
}
