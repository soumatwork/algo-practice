package practice.linkedlist;

public class Cyclicity {
  public static <T> boolean doesCycleExist(L<T> head) {
    L<T> slow = head;
    L<T> fast = head;

    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }

    return false;
  }

  public static void main(String[] args) {
    L<Integer> head = new L<>
            (2, new L<>(3, new L<>(4, new L<>(5,
                    new L<>(6, new L<>(7, null))))));
    doesCycleExist(head);
  }
}
