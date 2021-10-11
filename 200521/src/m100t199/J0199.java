package m100t199;

import utils.TreeNode;

import java.util.*;

public class J0199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        res.add(root.val);
        while(!deque.isEmpty()){
            int sz=deque.size();
            while(sz-->0){
                TreeNode node=deque.poll();
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
            if(!deque.isEmpty()) res.add(deque.peekLast().val);
        }
        return res;
    }
}
