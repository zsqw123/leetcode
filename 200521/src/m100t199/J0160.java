package m100t199;

import utils.ListNode;

public class J0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1=headA,n2=headB;
        if(n1==null||n2==null) return null;
        while(n1!=n2){
            n1=n1==null?headB:n1.next;
            n2=n2==null?headA:n2.next;
        }
        return n1;
    }
}
