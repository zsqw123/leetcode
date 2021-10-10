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

    // 2021-10-10 二刷
    public ListNode reverseKGroup2(ListNode head, int k) {
        if(head==null) return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,singlePre=dummy,tmp,start=head,now=head;
        int depth=0;
        while(head!=null){
            depth++;
            head=head.next;
        }
        int times=depth/k;
        for(int i=0;i<times;i++){
            for(int j=0;j<k;j++){
                tmp=now.next;
                now.next=pre;
                pre=now;
                now=tmp;
            }
            singlePre.next=pre;
            singlePre=start;
            start.next=now;
            start=now;
        }
        return dummy.next;
    }
}
