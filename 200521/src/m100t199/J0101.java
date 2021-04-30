package m100t199;

import utils.TreeNode;

import java.util.*;

public class J0101 {
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;
        Deque<TreeNode> que=new ArrayDeque<>();
        que.offer(root.left);
        que.offer(root.right);
        while(!que.isEmpty()){
            TreeNode l=que.poll();
            TreeNode r=que.poll();
            if(l.val!=r.val) return false;
            if(l.left!=null) que.offer(l.left);
            if(r.right!=null) que.offer(r.right);
            if((que.size()&1)==1) return false;
            if(l.right!=null) que.offer(l.right);
            if(r.left!=null) que.offer(r.left);
            if((que.size()&1)==1) return false;
        }
        return true;
    }

    /**
     * 递归做法, 其实效率更高吧?
     */
    class S2 {
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root,root);
        }
        public boolean isMirror(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            return (t1.val == t2.val)
                    && isMirror(t1.right, t2.left)
                    && isMirror(t1.left, t2.right);
        }
    }
}
