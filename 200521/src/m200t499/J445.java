package m200t499;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class J445 {
    Deque<Integer> deque1=new LinkedList<Integer>();
    Deque<Integer> deque2=new LinkedList<Integer>();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val==0) return l2;
        if(l2.val==0) return l1;
        while(l1!=null){
            deque1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            deque2.push(l2.val);
            l2=l2.next;
        }
        int overload=0;
        ListNode now=null;
        while(!(deque1.isEmpty()&&deque2.isEmpty())){
            int e1=deque1.isEmpty()?0:deque1.pop();
            int e2=deque2.isEmpty()?0:deque2.pop();
            int sum=e1+e2+overload;
            overload=sum/10;
            sum-=overload*10;
            ListNode tmp=new ListNode(sum);
            tmp.next=now;
            now=tmp;
        }
        if(overload!=0){
            ListNode tmp=new ListNode(overload);
            tmp.next=now;
            now=tmp;
        }
        return now;
    }
}
