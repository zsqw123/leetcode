package m100t199;

import utils.TreeNode;

import java.util.*;

public class J0144 {
    List<Integer> ints = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return ints;
        ints.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ints;
    }
}
