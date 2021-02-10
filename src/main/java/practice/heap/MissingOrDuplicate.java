package practice.heap;

import java.util.List;

public class MissingOrDuplicate {

  static class MissingAndDup {
    int duplicate;
    int missing;

    public MissingAndDup(int duplicate, int missing) {
      this.missing = missing;
      this.duplicate = duplicate;
    }

    @Override
    public String toString() {
      return "MissingAndDup{" + "duplicate=" + duplicate + ", missing=" + missing + '}';
    }
  }

  public static MissingAndDup find(List<Integer> a) {

    int xor = 0;
    for (int i = 0; i < a.size(); i++) {
      xor ^= i ^ a.get(i);
    }

    int diffBit = xor & (~(xor - 1));
    int mOrDup = 0;

    for (int i = 0; i < a.size(); i++) {
      if ((i & diffBit) != 0) {
        mOrDup ^= i;
      }

      if ((a.get(i) & diffBit) != 0) {
        mOrDup ^= i;
      }
    }

    return a.contains(mOrDup)
        ? new MissingAndDup(mOrDup, mOrDup ^ xor)
        : new MissingAndDup(mOrDup ^ xor, mOrDup);
  }

  public static void main(String[] args) {
    List<Integer> a = List.of(0, 1, 2, 4);
    System.out.println(find(a));
  }
}
