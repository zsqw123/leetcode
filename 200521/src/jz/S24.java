package jz;

import utils.ListNode;

public class S24 {
    public ListNode reverseList(ListNode head) {
        ListNode now,pre;
        pre=null;
        now=head;

        while(now!=null){
            ListNode tmp=now.next;
            now.next=pre;
            pre=now;
            now=tmp;
        }

        return pre;
    }
}
