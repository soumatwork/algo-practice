package practice.tree;

public class Symmetric {

  public static <T> boolean isSymmetric(Tree<T> t) {
    return c(t.left, t.right);
  }

  public static <T> boolean c(Tree<T> t1, Tree<T> t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 != null && t2 != null) {
      if (t1.data == t2.data && c(t1.left, t2.right) && c(t1.right, t2.left)) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Tree<Integer> t = new Tree<>(
      4, new Tree<>(
      2, null, new Tree<>(3, null, null)
    ), new Tree<>(2, new Tree<>(3, null, null), null));

    System.out.println(isSymmetric(t));
  }
}
