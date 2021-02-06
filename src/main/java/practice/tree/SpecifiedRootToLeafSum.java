package practice.tree;

public class SpecifiedRootToLeafSum {

  public static boolean doesExist(Tree<Integer> t, Integer remaining) {
    if (t == null) return false;

    int x = remaining - t.data;
    if (t.left == null && t.right == null) {
      return x == 0;
    }

    return doesExist(t.left, x) || doesExist(t.right, x);
  }

  public static void main(String[] args) {

  }
}
