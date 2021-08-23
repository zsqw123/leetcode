package jz;

import utils.ListNode;

public class S52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nowA=headA,nowB=headB;
        while(nowA!=nowB){
            if(nowA!=null) nowA=nowA.next;
            else nowA=headB;
            if(nowB!=null) nowB=nowB.next;
            else nowB=headA;
        }
        return nowB;
    }
}
