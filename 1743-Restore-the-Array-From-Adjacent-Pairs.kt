class Solution {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val counts = mutableMapOf<Int, Int>()
        val edges = mutableMapOf<Int, MutableList<Int>>()
        for ((u, v) in adjacentPairs) {
            counts[u] = counts.getOrDefault(u, 0) + 1
            counts[v] = counts.getOrDefault(v, 0) + 1

            edges.computeIfAbsent(u) { mutableListOf() }.add(v)
            edges.computeIfAbsent(v) { mutableListOf() }.add(u)
        }

        val visited = mutableSetOf<Int>()
        val answer = mutableListOf<Int>()
        var current = counts.filterValues { it == 1 }.map { it.key }.first()
        repeat(adjacentPairs.size + 1) {
            visited.add(current)
            answer.add(current)
            for (nextItem in edges[current] ?: emptyList()) {
                if (visited.contains(nextItem)) {
                    continue
                }
                current = nextItem
                break
            }
        }
        return answer.toIntArray()
    }
}
