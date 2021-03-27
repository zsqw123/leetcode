fun main() {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val list = mutableListOf<Int?>()
    fun TreeNode.printTree() {
        list += `val`
        if (left != null) {
            left!!.printTree()
        }
        if (right != null) {
            right!!.printTree()
        }
    }

    fun helper(
            preorder: IntArray, inorder: IntArray, preIndex: Int = 0, inS: Int = 0, inE: Int = preorder.size - 1
    ): TreeNode? {
        if (inS > inE) return null
        val rootNum = preorder[preIndex]
        val inIndex = inorder.indexOf(rootNum)
        val tree = TreeNode(rootNum)
        tree.left = helper(preorder, inorder, preIndex + 1, inS, inIndex - 1)
        tree.right = helper(preorder, inorder, preIndex + 1 + inIndex - inS, inIndex + 1, inE)
        return tree
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return helper(preorder, inorder)
    }

    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)
    val tree = buildTree(preorder, inorder)
    tree?.printTree()

    println(list)
}