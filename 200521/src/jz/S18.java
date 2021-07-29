package jz;

import utils.ListNode;

public class S18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy,now=head;
        while(now.val!=val){
            pre=now;
            now=now.next;
        }
        pre.next=now.next;
        return dummy.next;
    }
}
