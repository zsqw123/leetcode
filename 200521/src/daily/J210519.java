package daily;

import utils.ListNode;

public class J210519 {
    // 链表求和 https://leetcode-cn.com/problems/sum-lists-lcci/submissions/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1=l1,n2=l2;
        if(n1==null) return l2;
        if(n2==null) return l1;
        // 先对第一个处理
        int total=n1.val+n2.val;
        n1.val=total%10;
        int tmp=total/10;

        // 对都有的部分处理
        while(n1.next!=null && n2.next!=null){
            total=tmp+n1.next.val+n2.next.val;
            n1.next.val=total%10;
            tmp=total/10;
            n1=n1.next;
            n2=n2.next;
        }

        // 把 n2 链移到 n1
        if(n2.next!=null){
            n1.next=n2.next;
            if(tmp==0) return l1;
        }

        // 处理 n1 链
        while(n1.next!=null){
            total=tmp+n1.next.val;
            n1.next.val=total%10;
            tmp=total/10;
            n1=n1.next;
        }

        // 最后一个进位
        if(tmp!=0) n1.next=new ListNode(1);
        return l1;
    }
}
