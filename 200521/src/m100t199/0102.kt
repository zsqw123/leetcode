import utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    /**
     * 层序遍历, 使用非递归 dfs
     */
    fun levelOrder0(root: TreeNode?): List<List<Int>> {
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

    // BFS use Queue
    fun levelOrderBFS(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = ArrayList<ArrayList<Int>>()

        class IndexedNode(var node: TreeNode, var depth: Int)

        val queue: Queue<IndexedNode> = LinkedList<IndexedNode>()
        queue.add(IndexedNode(root, 1))
        while (queue.isNotEmpty()) {
            queue.poll().apply {
                if (depth > result.size) result.add(arrayListOf(node.`val`))
                else result[depth - 1].add(node.`val`)
                node.left?.let { queue.add(IndexedNode(it, depth + 1)) }
                node.right?.let { queue.add(IndexedNode(it, depth + 1)) }
            }
        }
        return result
    }

    /**
     * 自己瞎写的递归
     */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = ArrayList<ArrayList<Int>>()
        result.add(arrayListOf(root.`val`))

        fun next(node: TreeNode, level: Int) {
            if (node.left != null || node.right != null) {
                if (level > result.size - 1) {
                    val list = arrayListOf<Int>()
                    node.left?.let { list.add(it.`val`) }
                    node.right?.let { list.add(it.`val`) }
                    result.add(list)
                } else {
                    node.left?.let { result[level].add(it.`val`) }
                    node.right?.let { result[level].add(it.`val`) }
                }
                node.left?.let { next(node.left!!, level + 1) }
                node.right?.let { next(node.right!!, level + 1) }
            }
        }
        next(root, 1)
        return result
    }

    /**
     * 队列实现 堆栈实现事实上同理
     */
    fun levelOrder1(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = ArrayList<ArrayList<Int>>()
        result.add(arrayListOf(root.`val`))

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val list = arrayListOf<Int>()
            repeat(queue.size) {
                queue.poll().apply {
                    left?.let {
                        list.add(it.`val`)
                        queue.add(it)
                    }
                    right?.let {
                        list.add(it.`val`)
                        queue.add(it)
                    }
                }
            }
            if (list.isNotEmpty()) result.add(list)
        }
        return result
    }
}