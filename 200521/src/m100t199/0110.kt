import utils.TreeNode

fun main() {
    fun maxHeight(node: TreeNode?): Int =
        if (node == null) 0 else {
            if (maxHeight(node.left) > maxHeight(node.right)) maxHeight(node.left) + 1
            else maxHeight(node.right) + 1
        }

    // 超时....
    fun isBalanced1(root: TreeNode?): Boolean {
        if (root == null) return true
        return Math.abs(maxHeight(root.left) - maxHeight(root.right)) < 2
                && isBalanced1(root.left) && isBalanced1(root.right)
    }

    // 利用左右子树之差比较
    fun height(root: TreeNode?): Int {
        if (root == null) return 0
        val leftHeight = height(root.left)
        val rightHeight = height(root.right)
        return if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) -1
        else Math.max(leftHeight, rightHeight) + 1;
    }

    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) >= 0
    }
}