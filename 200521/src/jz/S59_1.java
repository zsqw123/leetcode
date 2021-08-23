package jz;

import java.util.LinkedList;

public class S59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0) return new int[0];
        // 队首是最大的
        var deque=new LinkedList<Integer>();
        int i=0;
        int[] res=new int[nums.length-k+1];
        while(i<k){
            // 单调递减栈
            while(!deque.isEmpty() && deque.peekLast()<nums[i])
                deque.removeLast();
            deque.addLast(nums[i++]);
        }
        res[0]=deque.peekFirst();
        while(i<nums.length){
            // 即将可能要出栈的元素
            if(deque.peekFirst()==nums[i-k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast()<nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            // 单调递减栈, 队首最大
            res[i-k+1]=deque.peekFirst();
            i++;
        }
        return res;
    }
}
