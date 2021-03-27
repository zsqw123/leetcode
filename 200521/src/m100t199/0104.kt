import utils.TreeNode
import java.util.*

fun maxDepth(root: TreeNode?): Int {
    return maxDepth((root ?: return 0).left).coerceAtLeast(maxDepth(root.right)) + 1
}

/**
 * 带深度的 dfs, 使用堆栈操作, 若左右节点均 null 则获取 max, 否则子节点深度 + 1, 继续循环
 * 事实上此题也可以使用bfs, 使用队列 Queue 操作, 先左后右插入, 效果一致
 *
 * @param root TreeNode?
 * @return Int
 */
fun maxDepthDFS(root: TreeNode?): Int {
    class IndexedNode(var node: TreeNode, var depth: Int)

    var maxDepth = 0
    val stack = Stack<IndexedNode>()

    stack.add(IndexedNode(root ?: return 0, 1))
    while (!stack.isEmpty()) {
        val indexedNode = stack.pop()
        val node = indexedNode.node
        if (node.left == null && node.right == null) {
            maxDepth = maxDepth.coerceAtLeast(indexedNode.depth)
        } else {
            node.right?.let { stack.add(IndexedNode(it, indexedNode.depth + 1)) }
            node.left?.let { stack.add(IndexedNode(it, indexedNode.depth + 1)) }
        }
    }

    return maxDepth
}

