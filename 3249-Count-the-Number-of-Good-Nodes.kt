class Solution {
    fun countGoodNodes(edges: Array<IntArray>): Int {
        val edgesByVertex = Array(edges.size + 1) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            edgesByVertex[a].add(b)
            edgesByVertex[b].add(a)
        }

        var answer = 0
        
        fun travel(current: Int, previous: Int): Int {
            val counts = mutableListOf<Int>()
            for (next in edgesByVertex[current]) {
                if (next == previous) {
                    continue
                }
                counts.add(travel(next, current))
            }
            if (counts.isEmpty() || counts.count { it == counts.first() } == counts.size) {
                answer += 1
            }
            return counts.sum() + 1
        }

        travel(0, -1)
        
        return answer
    }
}
