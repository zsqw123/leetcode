package jz;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S32_2 {
    ArrayList<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return res;
        le(root,0);
        return res;
    }
    void le(TreeNode root,int level){
        if(level>=res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        if(root.left!=null) le(root.left,level+1);
        if(root.right!=null) le(root.right,level+1);
    }
}
