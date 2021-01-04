import utils.TreeNode

fun main() {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        fun isBST(node: TreeNode?, min: Long, max: Long): Boolean {
            if (node == null) return true
            if (node.`val` <= min || node.`val` >= max) return false
            return isBST(node.left, min, node.`val`.toLong()) && isBST(node.right, node.`val`.toLong(), max)
        }
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}