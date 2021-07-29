package jz;

import utils.ListNode;

public class S25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    // 迭代
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode master,dummy=new ListNode(0);
        if(l1.val>l2.val){
            master=l2;
            l2=l2.next;
        }else{
            master=l1;
            l1=l1.next;
        }
        dummy.next=master;

        while(l1!=null || l2!=null){
            if(l1==null){
                master.next=l2;
                l2=l2.next;
            }else if(l2==null){
                master.next=l1;
                l1=l1.next;
            }else if(l1.val>l2.val){
                master.next=l2;
                l2=l2.next;
            }else{
                master.next=l1;
                l1=l1.next;
            }
            master=master.next;
        }
        return dummy.next;
    }
}
