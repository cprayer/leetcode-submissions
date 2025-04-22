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
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val answers = mutableListOf<List<Int>>()
        if (root != null) {
            process(root, mutableListOf(), 0, targetSum, answers)
        }
        return answers
    }

    fun process(node: TreeNode, paths: MutableList<Int>, sum: Int, targetSum: Int, answers: MutableList<List<Int>>) {
        val value = node.`val`
        if (node.left != null) {
            paths.add(value)
            process(node.left, paths, sum + value, targetSum, answers)
            paths.removeLast()
        }
        if (node.right != null) {
            paths.add(value)
            process(node.right, paths, sum + value, targetSum, answers)
            paths.removeLast()
        } 
        if (node.left == null && node.right == null) {
            if (sum + value == targetSum) {
                answers.add(paths.toMutableList() + value)
            }
        }
    }
}