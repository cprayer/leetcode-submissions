/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthLargestPerfectSubtree(root: TreeNode?, k: Int): Int {
        val perfectBinaryTrees = mutableListOf<Int>()
        build(root, perfectBinaryTrees)
        perfectBinaryTrees.sortDescending()
        return perfectBinaryTrees.getOrNull(k - 1) ?: -1
    }

    fun build(current: TreeNode?, perfectBinaryTrees: MutableList<Int>): Int {
        if (current == null) {
            return -1
        }

        if (current.left == null && current.right == null) {
            perfectBinaryTrees.add(1)
            return 1
        }

        val left = build(current.left, perfectBinaryTrees)
        val right = build(current.right, perfectBinaryTrees)

        return if (left != -1 && left == right) {
            perfectBinaryTrees.add(left + right + 1)
            left + right + 1
        } else {
            -1
        }
    }
}
