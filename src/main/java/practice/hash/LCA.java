package practice.hash;

import practice.tree.Tree;

import java.util.HashSet;
import java.util.Set;

public class LCA {

  public static <T> Tree<T> lca(Tree<T> n0, Tree<T> n1) {
    Set<Tree<T>> hash = new HashSet<>();
    while (n0 != null || n1 != null) {
      if (n0 != null) {
        if (!hash.add(n0)) return n0;
        n0 = n0.parent;
      }
      if (n1 != null) {
        if (!hash.add(n1)) return n1;
        n1 = n1.parent;
      }
    }

    throw new IllegalArgumentException("not found");
  }
}
