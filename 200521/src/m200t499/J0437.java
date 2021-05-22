package m200t499;

import utils.TreeNode;

public class J0437 {
    int count=0;
    void dfs(TreeNode root, int targetSum){
        if(root==null) return;
        targetSum-=root.val;
        if(targetSum==0) count++;

        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        dfs(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }
}
