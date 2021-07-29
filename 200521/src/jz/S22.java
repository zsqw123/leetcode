package jz;

import utils.ListNode;

public class S22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<k;i++)
            fast=fast.next;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
