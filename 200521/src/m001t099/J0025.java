package m001t099;

import utils.ListNode;

public class J0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), prev = dummy, curr = head, tmp;
        dummy.next = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }

        for(int i = 0; i < length / k; i++) {
            for(int j = 0; j < k - 1; j++) {
                tmp = curr.next;
                curr.next = curr.next.next;
                tmp.next = prev.next;
                prev.next = tmp;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
