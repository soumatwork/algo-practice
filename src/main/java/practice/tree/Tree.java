package practice.tree;

public class Tree<T> {
  public T data;
  public Tree<T> left;
  public Tree<T> right;
  public Tree<T> parent;
  public Tree<T> next;

  public Tree(T data, Tree<T> left, Tree<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public Tree(T data, Tree<T> left, Tree<T> right, Tree<T> parent) {
    this.data = data;
    this.left = left;
    this.right = right;
    this.parent = parent;
  }

}
