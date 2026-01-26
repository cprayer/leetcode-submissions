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
    private val adj = mutableMapOf<Int, MutableList<Int>>()

    fun amountOfTime(root: TreeNode?, start: Int): Int {
        travel(root)
        return bfs(start)
    }

    private fun bfs(start: Int): Int {
        var count = 0
        val visited = mutableSetOf<Int>()

        val deque = ArrayDeque<Int>()
        deque.add(start)
        visited.add(start)

        while(deque.isNotEmpty()) {
            val size = deque.size
            for (i in 0 until size) {
                val current = deque.removeFirst()
                for (next in adj[current] ?: emptyList()) {
                    if (visited.contains(next)) {
                        continue
                    }
                    visited.add(next)
                    deque.add(next)
                }
            }
            count += 1
        }
        return count - 1
    }


    private fun travel(current: TreeNode?) {
        if (current == null) {
            return
        }

        val currentV = current.`val`
        val leftV = current.left?.`val`
        val rightV = current.right?.`val`

        if (leftV != null) {
            adj.computeIfAbsent(currentV) { mutableListOf() }.add(leftV)
            adj.computeIfAbsent(leftV) { mutableListOf() }.add(currentV)
        }

        if (rightV != null) {
            adj.computeIfAbsent(currentV) { mutableListOf() }.add(rightV)
            adj.computeIfAbsent(rightV) { mutableListOf() }.add(currentV)
        }

        travel(current.left)
        travel(current.right)
    }
}
