package practice.tree.construct;

import practice.tree.Tree;

import java.util.Arrays;
import java.util.List;

public class ConstructTreeWithPre {

  public static class Pair<A, B> {
    public A a;
    public B b;

    public Pair(A a, B b) {
      this.a = a;
      this.b = b;
    }
  }

  public static <T> Tree<T> construct(List<T> preorder) {
    return construct(preorder, 0).a;
  }

  private static <T> Pair<Tree<T>, Integer> construct(List<T> preorder, Integer i) {
    T data = preorder.get(i);
    Integer x = i + 1;
    if (data == null) return new Pair<>(null, x);

    Pair<Tree<T>, Integer> left = construct(preorder, x);
    Pair<Tree<T>, Integer> right = construct(preorder, left.b);

    return new Pair<>(new Tree<>(data, left.a, right.a), right.b);
  }

  public static void main(String[] args) {
    Tree<Integer> t = construct(Arrays.asList(4, 2, 1, null, null, 3, null, null, 5, null, null));
    System.out.println(t);
  }
}
