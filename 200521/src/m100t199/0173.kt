package m100t199

import utils.TreeNode
import java.util.*

fun main() {
    class BSTIterator(root: TreeNode?) {
        private var node: TreeNode? = root
        private val stack = ArrayDeque<TreeNode>()
        fun next(): Int {
            if (hasNext()) {
                val tmp = stack.pollLast()
                node = tmp.right // 最小的没了 右侧一下
                return tmp.`val`
            }
            return -1
        }

        fun hasNext(): Boolean {
            if (node != null || stack.isNotEmpty())
                while (node != null) {
                    stack.addLast(node!!)
                    node = node!!.left // 找到最小的
                }
            return stack.isNotEmpty()
        }
    }
}