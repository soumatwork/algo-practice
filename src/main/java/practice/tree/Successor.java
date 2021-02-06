package practice.tree;

public class Successor {

  public static <T> Tree<T> successor(Tree<T> node) {
    Tree<T> i = node;
    if (i.right != null) {
      while (i.left != null) {
        i = i.left;
      }
      return i;
    }

    while (i.parent != null && i.parent.right == i) {
      i = i.parent;
    }

    return i.parent;
  }

  public static void main(String[] args) {

  }
}
