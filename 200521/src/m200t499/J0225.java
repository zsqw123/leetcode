package m200t499;

import java.util.LinkedList;
import java.util.Queue;

public class J0225 {
    class MyStack {
        Queue<Integer> in=new LinkedList<>();
        Queue<Integer> out=new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {}

        /** Push element x onto stack. */
        public void push(int x) {
            in.offer(x);
            while(!out.isEmpty())
                in.offer(out.poll());
            Queue<Integer> tmp=in;
            in=out;
            out=tmp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return out.poll();
        }

        /** Get the top element. */
        public int top() {
            return out.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return out.isEmpty();
        }
    }
}
