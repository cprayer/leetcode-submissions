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
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val sumItems = mutableListOf<Int>()
        val counts = mutableMapOf<Int, Int>()

        travel(root, sumItems)
        
        for (sumItem in sumItems) {
            counts[sumItem] = counts.getOrDefault(sumItem, 0) + 1
        }
        
        val maxValue = counts.maxBy { it.value }.value
        
        return counts.filterValues { it == maxValue }.keys.toIntArray()
    }

    private fun travel(current: TreeNode?, sumItems: MutableList<Int>): Int {
        if (current == null) {
            return 0
        }

        val leftSum = travel(current.left, sumItems)
        val rightSum = travel(current.right, sumItems)
        val currentSum = current.`val` + leftSum + rightSum

        sumItems.add(currentSum)
        return currentSum
    }
}
