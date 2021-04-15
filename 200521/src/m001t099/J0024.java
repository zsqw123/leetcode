package m001t099;

import utils.ListNode;

public class J0024 {
    // 画画图就行 很简单...
    public ListNode swapPairs(ListNode head) {
        ListNode g=new ListNode();
        g.next=head;
        ListNode pre=g;
        ListNode now=head;
        while(now!=null && now.next!=null){
            ListNode save=now.next.next;
            pre.next=now.next;
            now.next.next=now;
            pre=now;
            now.next=save;
            now=now.next;
        }
        return g.next;
    }
}
