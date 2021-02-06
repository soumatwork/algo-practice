package pk1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreAndIn {

  class T<A> {
    A root;
    T<A> l;
    T<A> r;

    T(A root, T<A> l, T<A> r) {
      this.root = root;
      this.l = l;
      this.r = r;
    }
  }

  T<Integer> t(List<Integer> in, List<Integer> pre) {
    Map<Integer, Integer> index = l(in);
    return t(in, pre, 0, in.size(), 0, pre.size(), index);
  }

  T t(List<Integer> in, List<Integer> pre, int s, int e, int ps, int pe, Map<Integer, Integer> index) {
    if (s <= e || ps <= pe) {
      return null;
    }

    int lSize = index.get(pre.get(ps)) - s;
    return new T(
            pre.get(ps),
            t(in, pre, s, index.get(pre.get(ps)), ps + 1, ps + 1 + lSize, index),
            t(in, pre, index.get(pre.get(ps)) + 1, e, ps + 1 + lSize, pe, index)
    );
  }

  Map<Integer, Integer> l(List<Integer> in) {
    Map<Integer, Integer> index = new HashMap<>();
    for (int i = 0; i < in.size(); i++) {
      index.put(in.get(i), i);
    }
    return index;
  }

  public static void main(String[] args) {
    System.out.println(new PreAndIn().t(Arrays.asList(2, 4, 5, 6, 7), Arrays.asList(6, 4, 2, 5, 7)));
  }
}
