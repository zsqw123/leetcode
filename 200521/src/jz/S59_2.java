package jz;

import java.util.LinkedList;

public class S59_2 {
    class MaxQueue {
        LinkedList<Integer> max=new LinkedList<>();
        LinkedList<Integer> que=new LinkedList<>();
        public MaxQueue() {

        }

        public int max_value() {
            return que.isEmpty() ? -1 : max.peek();
        }

        public void push_back(int value) {
            que.offer(value);
            while(!max.isEmpty() && max.peekLast()<value)
                max.removeLast();
            max.addLast(value);
        }

        public int pop_front() {
            if(que.isEmpty()) return -1;
            int pop=que.pop();
            if(max.peek()==pop) max.pop();
            return pop;
        }
    }

}
