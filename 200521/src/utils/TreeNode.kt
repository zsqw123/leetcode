package utils

import java.util.*

/**
 * leetcode 经典二叉树
 * @property `val` Int
 * @property left TreeNode?
 * @property right TreeNode?
 * @constructor
 */
class TreeNode(@JvmField var `val`: Int) {
    @JvmField
    var left: TreeNode? = null

    @JvmField
    var right: TreeNode? = null
    private fun stringlize(tabCount: Int): String {
        val sb = StringBuilder()
        repeat(tabCount) { sb.append("\t") }
        sb.append(`val`.toString())
        if (left != null || right != null) {
            sb.append(":")
            sb.append("\n")
            if (left == null) {
                repeat(tabCount + 1) { sb.append("\t") }
                sb.append("null")
            } else {
                sb.append(left!!.stringlize(tabCount + 1))
            }
            sb.append("\n")
            if (right == null) {
                repeat(tabCount + 1) { sb.append("\t") }
                sb.append("null")
            } else {
                sb.append(right!!.stringlize(tabCount + 1))
            }
        }
        return sb.toString()
    }

    override fun toString(): String = stringlize(0)

    companion object {
        @JvmStatic
        fun buildTree(array: Array<out Int?>): TreeNode? {
            if (array.isEmpty() || array[0] == null) return null
            val last = array.size - 1
            var item = array[0]
            val root = TreeNode(item!!)
            val que = ArrayDeque<TreeNode>()
            que.add(root)
            var index = 1
            while (que.isNotEmpty()) {
                val node = que.remove()
                if (index > last) break
                item = array[index++]
                if (item != null) {
                    node.left = TreeNode(item)
                    que.add(node.left!!)
                }
                if (index > last) break
                item = array[index++]
                if (item != null) {
                    node.right = TreeNode(item)
                    que.add(node.right!!)
                }
            }
            return root
        }
    }
}

fun Array<out Int?>.toTree(): TreeNode? = TreeNode.buildTree(this)

fun main() {
    arrayOf(
        1, 2, 3,
        null, 4, 5, 6,
        null, null, 7, 8, null, 9, 10, 11, null
    ).toTree().prl()
}