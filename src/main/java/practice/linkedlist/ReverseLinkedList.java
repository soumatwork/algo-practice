package practice.linkedlist;

public class ReverseLinkedList {

  public static <T> L<T> reverse(L<T> head, int s, int e) {
    L<T> dummyHead = new L<>(head.data, head);
    L<T> sublistHead = dummyHead;

    int k = 1;
    while (k++ < s) {
      sublistHead = sublistHead.next;
    }

    L<T> sublistIterator = sublistHead.next;
    while (s++ < e) {
      L<T> temp = sublistIterator.next;
      sublistIterator.next = temp.next;
      temp.next = sublistHead.next;
      sublistHead.next = temp;
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {
    L<Integer> head = new L<>
            (2, new L<>(3, new L<>(4, new L<>(5,
                    new L<>(6, new L<>(7, null))))));
    L<Integer> result = reverse(head, 2, 4);
    System.out.println(result);
  }
}
