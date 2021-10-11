package jz;

import utils.TreeNode;

import java.util.*;

public class S32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();

        deque.offer(root);
        boolean leftStart=false;
        List<Integer> single=new ArrayList<>();
        single.add(root.val);
        res.add(single);
        while(!deque.isEmpty()){
            LinkedList<TreeNode> tmp=new LinkedList<>();
            int sz=deque.size();
            for(int i=0;i<sz;i++){
                TreeNode now=deque.poll();
                if(now.left!=null) tmp.offer(now.left);
                if(now.right!=null) tmp.offer(now.right);
            }
            if(tmp.isEmpty()) break;
            List<Integer> r=new ArrayList<>();
            Iterator<TreeNode> it=leftStart?tmp.iterator():tmp.descendingIterator();
            while(it.hasNext())r.add(it.next().val);
            res.add(r);
            deque=tmp;
            leftStart=!leftStart;
        }
        return res;
    }
}
