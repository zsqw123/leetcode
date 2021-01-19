import utils.TreeNode
import java.util.*

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

    fun isValidBST0(root: TreeNode?): Boolean {
        if (root == null) return true
        class LimitedNode(var node: TreeNode, var min: Long, var max: Long)

        val queue: Queue<LimitedNode> = LinkedList()
        queue.add(LimitedNode(root, root.`val`.toLong(), root.`val`.toLong()))
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                queue.poll().apply {
                    node.left?.let {
                        if (it.`val` <= min || it.`val` >= max) return false
                        queue.add(LimitedNode(it, it.`val`.toLong(), min))
                    }
                    node.right?.let {
                        if (it.`val` <= min || it.`val` >= max) return false
                        queue.add(LimitedNode(it, max, it.`val`.toLong()))
                    }
                }
            }
        }
        return true
    }
}