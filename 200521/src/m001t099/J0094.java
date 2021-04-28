package m001t099;

import utils.TreeNode;

import java.util.*;

public class J0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode cur=root;
        TreeNode pre;
        while(cur!=null){
            if(cur.left==null){
                res.add(cur.val);
                cur=cur.right;
                continue;
            }
            pre=cur.left;
            while(pre.right!=null && pre.right!=cur) pre=pre.right;
            if(pre.right==cur) {
                pre.right=null;
                res.add(cur.val);
                cur=cur.right;
            }else{
                pre.right=cur;
                cur=cur.left;
            }
        }
        return res;
    }
}
