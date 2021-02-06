package practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {
  public static <T> List<T> tIn(Tree<T> t) {
    if (t != null) {
      List<T> l = tIn(t.left);
      List<T> x = v(t);
      List<T> r = tIn(t.right);
      l.addAll(x);
      l.addAll(r);
      return l;
    }
    return new ArrayList<>();
  }

  public static <T> List<T> tPre(Tree<T> t) {
    if (t != null) {
      List<T> x = v(t);
      List<T> l = tPre(t.left);
      List<T> r = tPre(t.right);
      x.addAll(l);
      x.addAll(r);
      return x;
    }
    return new ArrayList<>();
  }

  public static <T> List<T> tPost(Tree<T> t) {
    if (t != null) {
      List<T> l = tPost(t.left);
      List<T> r = tPost(t.right);
      List<T> x = v(t);
      l.addAll(r);
      l.addAll(x);
      return l;
    }
    return new ArrayList<>();
  }

  public static <T> List<T> v(Tree<T> t) {
    return Arrays.asList(t.data);
  }

  public static void main(String[] args) {
    Tree<Integer> t = new Tree<>(
      4, new Tree<>(
      2, new Tree<>(1, null, null), new Tree<>(3, null, null)
    ), new Tree<>(6, new Tree<>(5, null, null), new Tree<>(7, null, null)));

    System.out.println(tPost(t));
  }
}
