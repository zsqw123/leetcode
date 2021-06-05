package m200t499;

import utils.TreeNode;

public class J0226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode t=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=t;
        return root;
    }
}
