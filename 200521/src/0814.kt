import utils.TreeNode

fun main() {
    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        root.left = pruneTree(root.left)
        root.right = pruneTree(root.right)
        return if (root.left == null && root.right == null && root.`val` == 0) null
        else root
    }
}