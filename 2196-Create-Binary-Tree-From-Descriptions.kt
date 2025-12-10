/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *   var left: TreeNode? = null
 *   var right: TreeNode? = null
 * }
 */

class Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val counts = mutableMapOf<Int, Int>()
        val nodesByValue = mutableMapOf<Int, TreeNode>()
        for ((parent, child, isLeft) in descriptions) {
            val parentNode = nodesByValue.computeIfAbsent(parent) { TreeNode(parent) }
            val childNode = nodesByValue.computeIfAbsent(child) { TreeNode(child) }
            if (isLeft == 1) {
                parentNode.left = childNode
            } else {
                parentNode.right = childNode
            }
            counts[child] = counts.getOrDefault(child, 0) + 1
        }

        for ((value, node) in nodesByValue) {
            if (counts.getOrDefault(value, 0) == 0) {
                return node
            }
        }

        return null
    }
}
