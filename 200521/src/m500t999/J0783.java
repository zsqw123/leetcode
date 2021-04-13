package m500t999;

import utils.TreeNode;
import java.util.*;

public class J0783 {
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node=stack.pop();
            list.add(node.val);
            root=node.right;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++)
            min=Math.min(min,list.get(i+1)-list.get(i));
        return min;
    }
    public static void main(String[] args) {
        Integer[] a ={1,2,null};
        TreeNode.buildTree(a);
    }
}
