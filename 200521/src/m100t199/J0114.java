package m100t199;

import utils.TreeNode;

public class J0114 {
    /**
     * 常规做法 模拟前序遍历
     */
    class S1{
        public void flatten(TreeNode root) {
            if(root==null) return;
            flatten(root.left);
            flatten(root.right);

            TreeNode tmp=root.right;
            root.right=root.left;
            root.left=null;
            while(root.right!=null) root=root.right;
            root.right=tmp;
        }
    }

    /**
     * 评论区大佬做法
     */
    class S2{
        /**
         * last 节点指向右侧 root 节点
         * 但如果存在左侧 root 节点则指向左侧 root
         */
        TreeNode last;
        public void flatten(TreeNode root) {
            if(root==null) return;
            flatten(root.right);
            flatten(root.left);
            root.right=last;
            root.left=null;
            last=root;
        }
    }
    // 非递归解法
    class S3 {
        public void flatten(TreeNode root) {
            TreeNode cur=root,pre,tmp;
            while(cur!=null){
                if(cur.left==null){
                    cur=cur.right;continue;
                }

                pre=cur.left; // 找到左子树最右节点
                while(pre.right!=null) pre=pre.right;
                pre.right=cur.right; // 将左子树最右节点指向当前右子树

                tmp=cur.left; // 将左子树赋为右子树
                cur.left=null;
                cur.right=tmp;

                cur=cur.right;
            }
        }
    }
}
