import java.lang.Integer.max

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
    var answer = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        visit(root)
        return answer
    }

    fun visit(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val left = visit(root.left)
        val right = visit(root.right)

        answer = max(answer, left + right)
        return max(left, right) + 1
    }

}
