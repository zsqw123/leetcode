package m200t499;

import utils.ListNode;

public class J0203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        if(head.next==null){
            if(head.val==val) return null;
            else return head;
        }

        ListNode dummy=new ListNode();
        dummy.next=head;
        head=dummy;
        do{
            if(head.next.val==val) head.next=head.next.next;
            else head=head.next;
        }while(head.next!=null);
        return dummy.next;
    }
}
