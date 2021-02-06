package practice.tree;

public class HeightBalanced<T> {

  static class Meta {
    public boolean balanced;
    public int height;

    public Meta(boolean balanced, int height) {
      this.balanced = balanced;
      this.height = height;
    }
  }

  public static <T> boolean heightBalanced(Tree<T> t) {
    return t(t).balanced;
  }

  public static <T> Meta t(Tree<T> r) {
    if (r == null) {
      return new Meta(true, -1);
    }
    Meta a = t(r.left);
    if (!a.balanced) return a;
    Meta b = t(r.right);
    if (!b.balanced) return b;

    return v(r, a, b);

  }

  private static <T> Meta v(Tree<T> r, Meta left, Meta right) {
    int height = Math.max(left.height, right.height) + 1;
    return new Meta(Math.abs(left.height - right.height) <= 1, height);
  }

  public static void main(String[] args) {
    Tree<Integer> t = new Tree<>(4,
      new Tree<>(2,
        new Tree<>(1,
          new Tree<>(15,
            new Tree<>(16,
              null,
              null
            ),
            null
          ),
          null
        ),
        new Tree<>(3, null, null)
      ),
      new Tree<>(6,
        new Tree<>(5, null, null),
        new Tree<>(7, null, null)
      )
    );

    System.out.println(heightBalanced(t));
  }
}
