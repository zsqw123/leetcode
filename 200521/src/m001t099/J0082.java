package m001t099;

import utils.ListNode;

public class J0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy, now = head;
        boolean flag = false;
        while (now.next != null) {
            if (now.val == now.next.val) flag = true;
            else if (flag) {
                p.next = now.next;
                flag = false;
            } else p = now;
            now = now.next;
        }
        if (flag) p.next = null;
        return dummy.next;
    }
}
