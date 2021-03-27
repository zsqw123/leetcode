import utils.TreeNode

fun main() {
    // 左子树深度
    fun leftDepth(node: TreeNode?): Int {
        var depthNode: TreeNode? = node
        var depth = 0
        while (depthNode != null) {
            depthNode = depthNode.left
            depth++
        }
        return depth
    }

    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        val lDepth = leftDepth(root.left)
        val rDepth = leftDepth(root.right)

        // 若左排深度和右排一致, 那么说明左排已经满了, 数量为 2^lDepth, 右侧参与递归
        // 若...........不一致, 则说明右排已经满了, 数量为 2^rDepth, 左侧参与递归
        return if (lDepth == rDepth) (1 shl lDepth) + countNodes(root.right)
        else (1 shl rDepth) + countNodes(root.left)
    }
}