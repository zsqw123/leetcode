package jz;

import utils.TreeNode;

public class S27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left=mirrorTree(root.right);
        TreeNode right=mirrorTree(root.left);
        root.left=left;
        root.right=right;
        return root;
    }
}
