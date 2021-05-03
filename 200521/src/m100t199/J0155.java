package m100t199;

import java.util.ArrayDeque;

public class J0155 {
    class MinStack {
        ArrayDeque<Integer> que=new ArrayDeque<>();
        ArrayDeque<Integer> minQ=new ArrayDeque<>();
        MinStack(){
            minQ.push(Integer.MAX_VALUE);
        }
        public void push(int val) {
            if(val<=minQ.peek()) minQ.push(val);
            que.push(val);
        }

        public void pop() {
            if(que.pop().equals(minQ.peek())) minQ.pop();
        }

        public int top() {
            return que.peek();
        }

        public int getMin() {
            return minQ.peek();
        }
    }
}
