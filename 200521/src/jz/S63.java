package jz;

import java.util.LinkedList;

public class S63 {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=1;i<prices.length;i++){
            max=Math.max(prices[i]-prices[i-1],max);
            prices[i]=Math.min(prices[i],prices[i-1]);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        var que=new LinkedList<Integer>();
        int max=0;
        for(int i:prices){
            while(!que.isEmpty() && que.peek()>i){
                int last=que.peekLast();
                int pop=que.pop();
                max=Math.max(pop-last,max);
            }
            que.push(i);
        }
        if(!que.isEmpty()){
            int last=que.peekLast();
            int pop=que.pop();
            max=Math.max(pop-last,max);
        }
        return max;
    }
}
