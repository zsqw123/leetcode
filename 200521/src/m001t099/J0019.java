package m001t099;

import utils.ListNode;

public class J0019 {
    int cur = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        head.next = removeNthFromEnd(head.next, n);
        if (++cur == n) return head.next;
        return head;
    }
}
