package practice.tree;

public class LowestCommonAncestor {

  static class Meta<T> {
    public Integer numberOfNodes;
    public Tree<T> ancestor;

    public Meta(Integer numberOfNodes, Tree<T> ancestor) {
      this.numberOfNodes = numberOfNodes;
      this.ancestor = ancestor;
    }
  }

  public static <T> T lca(Tree<T> t, Tree<T> node0, Tree<T> node1) {
    return lcaFinder(t, node0, node1).ancestor.data;
  }

  public static <T> Meta<T> lcaFinder(Tree<T> t, Tree<T> node0, Tree<T> node1) {
    if (t == null) {
      return new Meta<T>(0, null);
    }
    Meta<T> left = lcaFinder(t.left, node0, node1);
    if (left.numberOfNodes == 2) return left;
    Meta<T> right = lcaFinder(t.right, node0, node1);
    if (left.numberOfNodes == 2) return right;
    return v(t, node0, node1, left, right);
  }

  public static <T> Meta<T> v(Tree<T> t, Tree<T> node0, Tree<T> node1, Meta<T> left, Meta<T> right) {
    int numberOfNodes = left.numberOfNodes + right.numberOfNodes;
    if (t.data == node0.data) numberOfNodes += 1;
    if (t.data == node1.data) numberOfNodes += 1;

    return new Meta<>(numberOfNodes, (numberOfNodes == 2) ? t : null);
  }

  public static void main(String[] args) {
    Tree<Integer> t = new Tree<>(
      4, new Tree<>(
      2, new Tree<>(1, null, null), new Tree<>(3, null, null)
    ), new Tree<>(6, new Tree<>(5, null, null), new Tree<>(7, null, null)));

    System.out.println(lca(t, new Tree<>(1, null, null), new Tree<>(5, null, null)));
  }
}
