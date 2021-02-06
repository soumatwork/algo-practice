package practice.tree;

public class BinaryRootToLeafPath {

  public static Integer sum(Tree<Integer> t) {
    return sum(t, 0);
  }

  public static Integer sum(Tree<Integer> t, Integer partial) {
    if (t == null) return 0;

    Integer x = 2 * partial + t.data;
    if (t.left == null && t.right == null) return x;

    return sum(t.left, x) + sum(t.right, x);
  }

  public static void main(String[] args) {

  }
}
