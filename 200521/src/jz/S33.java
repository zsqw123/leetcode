package jz;

import java.util.LinkedList;

public class S33 {
    public boolean verifyPostorder(int[] postorder) {
        var stack=new LinkedList<Integer>();
        int rightRoot=Integer.MAX_VALUE;

        for(int i=postorder.length-1;i>=0;i--){
            if(postorder[i]>rightRoot) return false;
            while(!stack.isEmpty() && stack.peek()>postorder[i]) rightRoot=stack.pop();
            stack.push(postorder[i]);
        }
        return true;
    }
}
