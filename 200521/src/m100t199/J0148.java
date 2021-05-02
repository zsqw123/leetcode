package m100t199;

import utils.ListNode;

public class J0148 {
    class Solution {
        ListNode merge(ListNode cur1, ListNode cur2){
            if(cur1==null) return cur2;
            if(cur2==null) return cur1;
            if(cur1.val<=cur2.val){
                cur1.next=merge(cur1.next,cur2);
                return cur1;
            }else{
                cur2.next=merge(cur2.next,cur1);
                return cur2;
            }
        }
        public ListNode sortList(ListNode head) {
            if(head==null || head.next==null) return head;
            ListNode fast=head.next;
            ListNode slow=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode tmp=slow.next;
            slow.next=null;
            return merge(sortList(head),sortList(tmp));
        }
    }
}
