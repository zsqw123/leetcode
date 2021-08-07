package jz;

import utils.TreeNode;

import java.util.LinkedList;

public class S32 {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        var queue=new LinkedList<TreeNode>();
        var res=new LinkedList<Integer>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode now=queue.poll();
            res.add(now.val);
            if(now.left!=null) queue.add(now.left);
            if(now.right!=null) queue.add(now.right);
        }
        int[] r=new int[res.size()];
        int i=0;
        for(int j:res) r[i++]=j;
        return r;
    }
}
