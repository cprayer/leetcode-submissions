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
class CBTInserter(root: TreeNode?) {

    val nodes = Array<TreeNode?>(10009) { null }
    var length = 0

    init {
        construct(root)
    }

    private fun construct(root: TreeNode?) {
        val queue = ArrayDeque<TreeNode?>()
        if (root == null) {
            return
        }
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for(i in 0 until size) {
                val item = queue.removeFirst()
                nodes[++length]  = item
                if (item?.left != null) {
                    queue.add(item.left)
                }
                if (item?.right != null) {
                    queue.add(item.right)
                }
            }
        }
    }

    fun insert(`val`: Int): Int {
        nodes[++length] = TreeNode(`val`)
        val parentNode = nodes[length / 2] ?: throw IllegalStateException()
        when (length % 2) {
            0 -> parentNode.left = nodes[length]
            1 -> parentNode.right = nodes[length]
        }
        return parentNode.`val`
    }

    fun get_root(): TreeNode? {
        return nodes[1]
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * var obj = CBTInserter(root)
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.get_root()
 */
