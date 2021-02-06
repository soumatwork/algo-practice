package practice.tree;

public class LowestCommonAncestorParent {

  public static <T> T lca(Tree<T> node0, Tree<T> node1) {
    int depth0 = depth(node0);
    int depth1 = depth(node1);

    if (depth1 > depth0) {
      Tree<T> temp = node0;
      node0 = node1;
      node1 = temp;
    }

    int depthDiff = Math.abs(depth0 - depth1);
    while (depthDiff-- > 0) {
      node0 = node0.parent;
    }

    while (node0!= node1) {
      node0 = node0.parent;
      node1 = node1.parent;
    }

    return node0.data;
  }

  public static <T> Integer depth(Tree<T> t) {
    int d = 0;
    while (t != null) {
      d++;
      t = t.parent;
    }
    return d;
  }

  public static void main(String[] args) {
    Tree<Integer> t = new Tree<>(
      4, new Tree<>(
      2, new Tree<>(1, null, null), new Tree<>(3, null, null)
    ), new Tree<>(6, new Tree<>(5, null, null), new Tree<>(7, null, null)));

    t.left.parent = t;
    t.right.parent = t;

    t.left.left.parent = t.left;
    t.left.right.parent = t.left;

    t.right.left.parent = t.right;
    t.right.right.parent = t.right;

    System.out.println(lca(t.left.left, t.right.right));
  }
}
