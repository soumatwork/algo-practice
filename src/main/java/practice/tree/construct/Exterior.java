package practice.tree.construct;

import practice.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exterior {

  public static <T> List<Tree<T>> compute(Tree<T> t) {
    List<Tree<T>> result = new ArrayList<>();
    ext(t, result);
    return result;
  }

  public static <T> void ext(Tree<T> t, List<Tree<T>> result) {
    if (t == null) return;

    result.add(t);

    leftBoundary(t.left, result);
    leaves(t.left, result);
    leaves(t.right, result);
    rightBoundary(t.right, result);
  }

  public static <T> void leftBoundary(Tree<T> t, List<Tree<T>> result) {
    if (t == null || (t.left == null && t.right == null)) return;

    result.add(t);
    if (t.left != null) {
      leftBoundary(t.left, result);
    } else {
      leftBoundary(t.right, result);
    }
  }

  public static <T> void rightBoundary(Tree<T> t, List<Tree<T>> result) {
    if (t == null || (t.left == null && t.right == null)) return;

    if (t.right != null) {
      rightBoundary(t.right, result);
    } else {
      rightBoundary(t.left, result);
    }
    result.add(t);
  }

  public static <T> void leaves(Tree<T> t, List<Tree<T>> result) {
    if (t == null) return;
    if (t.left == null && t.right == null) {
      result.add(t);
      return;
    }

    leaves(t.left, result);
    leaves(t.right, result);
  }


  public static void main(String[] args) {
    Tree<Integer> t = new Tree<>(
      4, new Tree<>(
      2, null, new Tree<>(3, new Tree<>(1, null, null), null)
    ), new Tree<>(6, new Tree<>(5, null, null), new Tree<>(7, null, null)));

    System.out.println(compute(t).stream().map(a -> a.data).collect(Collectors.toList()));
  }
}
