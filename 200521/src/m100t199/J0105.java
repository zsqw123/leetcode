package m100t199;

import utils.TreeNode;

import java.util.HashMap;

public class J0105 {
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return rebuild(preorder,0,preorder.length-1,0);
    }
    TreeNode rebuild(int[] pre, int preIdx, int preRIdx, int inIdx){
        if(preIdx>preRIdx) return null;
        TreeNode root=new TreeNode(pre[preIdx]);
        int leftSize=map.get(root.val)-inIdx;
        root.left=rebuild(pre,preIdx+1,preIdx+leftSize,inIdx);
        root.right=rebuild(pre,preIdx+leftSize+1,preRIdx,inIdx+leftSize+1);
        return root;
    }
}
