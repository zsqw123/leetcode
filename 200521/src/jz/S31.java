package jz;

import java.util.LinkedList;

public class S31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        var stack = new LinkedList<Integer>();
        int j = 0;
        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;

    }
}
