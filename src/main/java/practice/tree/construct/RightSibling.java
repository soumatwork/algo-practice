package practice.tree.construct;

import practice.tree.Tree;

public class RightSibling {

  public static <T> void compute(Tree<T> t) {
    while (t != null) {
      rightSibling(t);
      t = t.left;
    }
  }

  public static <T> void rightSibling(Tree<T> t) {
    while (t != null && t.left != null) {
      t.left.next = t.right;

      if (t.next != null) {
        t.right.next = t.next.left;
      }
      t = t.next;
    }
  }

  public static void main(String[] args) {
    
  }
}
