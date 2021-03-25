package utils

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
}