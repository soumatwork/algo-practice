package pk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Abc {
  List<List<Integer>> p(List<Integer> x) {
    List<List<Integer>> r = new ArrayList<>();
    p(x, 0, r);
    return r;
  }

  void p(List<Integer> x, int k, List<List<Integer>> r) {
    if (k == x.size() - 1) {
      r.add(new ArrayList<>(x));
      return;
    }

    for (int i = k; i < x.size(); i++) {
      Collections.swap(x, k, i);
      p(x, k + 1, r);
      Collections.swap(x, k, i);
    }
  }

  public static void main(String[] args) {
    List<Integer> x = Arrays.asList(1, 2, 3);
    System.out.println(new Abc().p(x));
  }
}