package jz;

import java.util.Deque;
import java.util.LinkedList;

public class S30 {
    Deque<Integer> stack=new LinkedList<>();
    Deque<Integer> mins=new LinkedList<>();

    /** initialize your data structure here. */
    public S30() {
        mins.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        mins.push(x>mins.peek()?mins.peek():x);
    }

    public void pop() {
        mins.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return mins.peek();
    }
}
