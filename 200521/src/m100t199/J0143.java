package m100t199;

import utils.ListNode;

public class J0143 {
    public void reorderList(ListNode head) {
        // 快慢指针查找 ListNode 中间节点
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow.next==null) return;
        ListNode start=head,mid=slow.next;
        slow.next=null; // 剪短中间节点
        // 后段节点倒序
        ListNode pre=null,now=mid;
        while(now.next!=null){
            ListNode tmp=now.next;
            now.next=pre;
            pre=now;
            now=tmp;
        }
        now.next=pre;
        // 链接节点
        while(start!=null && now!=null){
            ListNode tmp1=start.next;
            ListNode tmp2=now.next;
            now.next=tmp1;
            start.next=now;
            now=tmp2;
            start=tmp1;
        }
    }
}
