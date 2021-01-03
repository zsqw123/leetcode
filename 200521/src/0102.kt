import utils.TreeNode
import java.util.*

fun main() {
    /**
     * 层序遍历, 使用非递归 dfs
     * @param root TreeNode?
     * @return List<List<Int>>
     */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = ArrayList<ArrayList<Int>>()

        class IndexedNode(var node: TreeNode, var depth: Int)

        val stack = Stack<IndexedNode>()
        stack.add(IndexedNode(root, 1))
        while (!stack.isEmpty()) {
            stack.pop().apply {
                if (depth > result.size) result.add(arrayListOf(node.`val`))
                else result[depth - 1].add(node.`val`)
                node.right?.let { stack.add(IndexedNode(it, depth + 1)) }
                node.left?.let { stack.add(IndexedNode(it, depth + 1)) }
            }
        }
        return result
    }
}