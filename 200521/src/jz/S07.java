package jz;

import utils.TreeNode;

import java.util.HashMap;

/**
 * 复制到IDE的时候发现, 可以省一个参数, 但没必要, 存档这个方便理解
 */
public class S07 {
    HashMap<Integer,Integer> map=new HashMap<>();
    int[] preorder,inorder;
    TreeNode dfs(int preStart, int preEnd, int inStart, int inEnd){
        if(preEnd<preStart)return null;
        TreeNode head=new TreeNode(preorder[preStart]);
        int inSelect=map.get(preorder[preStart]);
        int leftSz=inSelect-inStart,rightSz=inEnd-inSelect;
        head.left=dfs(preStart+1,preStart+leftSz,inStart,inSelect-1);
        head.right=dfs(preStart+leftSz+1,preEnd,inSelect+1,inEnd);
        return head;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int sz=preorder.length;
        if(preorder.length==0) return null;
        this.inorder=inorder;
        this.preorder=preorder;
        for(int i=0;i<sz;i++) map.put(inorder[i],i);
        return dfs(0,sz-1,0,sz-1);
    }
}
