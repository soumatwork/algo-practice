package practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

  public static <T> void t(Tree<T> t) {
    if (t != null) {
      Queue<Tree<T>> q = new LinkedList<>();
      q.offer(t);
      while (!q.isEmpty()) {
        Tree<T> a = q.poll();
        v(a);
        if (a.left != null) q.offer(a.left);
        if (a.right != null) q.offer(a.right);
      }
    }
  }

  public static <T> void v(Tree<T> t) {
    System.out.print(t.data + ",");
  }

  public static void main(String[] args) {
    Tree<Integer> t = new Tree<>(
      4, new Tree<>(
      2, new Tree<>(1, null, null), new Tree<>(3, null, null)
    ), new Tree<>(6, new Tree<>(5, null, null), new Tree<>(7, null, null)));

    t(t);
  }
}
