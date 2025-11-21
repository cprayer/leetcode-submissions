class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) {
            return listOf(0)
        }
        
        val counts = Array(n) { 0 }
        val edgesByVertex = mutableMapOf<Int, MutableSet<Int>>()
        for ((a, b) in edges) {
            counts[a] += 1
            counts[b] += 1
            edgesByVertex.computeIfAbsent(a) { mutableSetOf() }.add(b)
            edgesByVertex.computeIfAbsent(b) { mutableSetOf() }.add(a)
        }

        val deque = ArrayDeque<Int>()
        for ((i, count) in counts.withIndex()) {
            if (count == 1) {
                deque.add(i)
            }
        }

        val current = mutableListOf<Int>()
        while (deque.isNotEmpty()) {
            current.clear()

            val size = deque.size
            for (i in 0 until size) {
                val a = deque.removeFirst()
                current += a
                val b = edgesByVertex.getValue(a).firstOrNull() ?: continue

                counts[b] -= 1
                if (counts[b] == 1) {
                    deque.add(b)
                }
                edgesByVertex.getValue(b).remove(a)
            }
        }

        return current
    }
}
