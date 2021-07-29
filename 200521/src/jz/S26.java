package jz;

import utils.TreeNode;

public class S26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return dfs(A,B,false);
    }
    boolean dfs(TreeNode A, TreeNode B,boolean start){
        if(B==null || A==null) return false;
        boolean res=false;
        if(A.val==B.val){
            if(B.left==null && B.right==null){
                return true;
            }else if(B.left==null){
                res=dfs(A.right,B.right,true);
            }else if(B.right==null){
                res=dfs(A.left,B.left,true);
            }else{
                res=dfs(A.left,B.left,true) && dfs(A.right,B.right,true);
            }
        }
        if(res) return true;
        return !start && (dfs(A.left,B,false)||dfs(A.right,B,false));
    }
}
