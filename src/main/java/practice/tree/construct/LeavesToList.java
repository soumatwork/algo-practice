package practice.tree.construct;

import practice.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LeavesToList {

  public static <T> List<T> toList(Tree<T> t) {
    List<T> result = new ArrayList<>();
    traverse(t, result);
    return result;
  }

  public static <T> void traverse(Tree<T> t, List<T> result) {
    if (t != null) {
      if (t.left == null && t.right == null) {
        result.add(t.data);
      } else {
        traverse(t.left, result);
        traverse(t.right, result);
      }
    }
  }

  public static void main(String[] args) {
    Tree<Integer> t = new Tree<>(
      4, new Tree<>(
      2, new Tree<>(1, null, null), new Tree<>(3, null, null)
    ), new Tree<>(6, new Tree<>(5, null, null), new Tree<>(7, null, null)));

    List<Integer> l = toList(t);
    System.out.println(l);
  }
}
