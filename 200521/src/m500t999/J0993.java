package m500t999;

import utils.TreeNode;

public class J0993 {
    int now=-1;
    boolean dfs(TreeNode root,int x,int y,int dep){
        if(root==null) return false;
        if(root.left!=null && root.right!=null &&
                ((root.left.val==x && y==root.right.val)||
                        (root.left.val==y && x==root.right.val))) return false;
        if(root.val==x || root.val==y){
            if(now==-1) now=dep;
            else return now==dep;
        }
        return dfs(root.left,x,y,dep+1)||dfs(root.right,x,y,dep+1);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        return dfs(root,x,y,0);
    }
}
