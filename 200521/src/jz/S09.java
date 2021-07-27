package jz;

import java.util.Stack;

public class S09 {
    class CQueue {
        Stack<Integer> stack0=new Stack<>();
        Stack<Integer> stack1=new Stack<>();
        public CQueue() {

        }

        public void appendTail(int value) {
            stack0.push(value);
        }

        public int deleteHead() {
            if(stack1.isEmpty()){
                while(!stack0.isEmpty()){
                    stack1.push(stack0.pop());
                }
            }
            if(stack1.isEmpty()) return -1;
            return stack1.pop();
        }
    }
}
