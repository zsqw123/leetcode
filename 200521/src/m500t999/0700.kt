import utils.TreeNode

fun main() {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` > `val`) {
            return if (root.left != null) searchBST(root.left, `val`)
            else null
        }
        if (root.`val` < `val`) {
            return if (root.right != null) searchBST(root.right, `val`)
            else null
        }
        return root
    }
}