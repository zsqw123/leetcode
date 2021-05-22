package m100t199;

import utils.TreeNode;

public class J0104 {
    int dfs(TreeNode root, int dep){
        if(root==null) return dep;
        return Math.max(dfs(root.left,dep+1),dfs(root.right,dep+1));
    }
    public int maxDepth(TreeNode root) {
        return dfs(root,0);
    }
}
