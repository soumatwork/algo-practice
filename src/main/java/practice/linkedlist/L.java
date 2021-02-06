package practice.linkedlist;

public class L<T> {
  T data;
  L<T> next;

  public L(T data, L<T> next) {
    this.data = data;
    this.next = next;
  }

//  @Override
//  public String toString() {
//    StringBuilder x = new StringBuilder();
//    L<T> i = new L<>(data, new L<>(data, next));
//
//    for (; i.next != null; i = i.next) {
//      L<T> a = i.next;
//      x.append(a.data).append(",");
//    }
//
//    x.setLength(x.length() - 1);
//    return x.toString();
//  }
}
