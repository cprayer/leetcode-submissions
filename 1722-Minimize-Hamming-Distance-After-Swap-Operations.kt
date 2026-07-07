import kotlin.math.max

class Solution {

    fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val groups = IntArray(source.size)
        for (i in groups.indices) {
            groups[i] = i
        }

        fun find(current: Int): Int {
            if (groups[current] == current) {
                return current
            }
            groups[current] = find(groups[current])
            return groups[current]
        }

        fun merge(i: Int, j: Int) {
            var a = find(i)
            var b = find(j)

            if (a > b) {
                val t = a
                a = b
                b = t
            }

            groups[b] = a
        }

        for ((i, j) in allowedSwaps) {
            merge(i, j)
        }

        val sourcesByGroup = hashMapOf<Int, MutableList<Int>>()
        val targetsByGroup = hashMapOf<Int, MutableList<Int>>()
        for (i in source.indices) {
            val sourceValue = source[i]
            val targetValue = target[i]
            val group = find(i)
            sourcesByGroup.computeIfAbsent(group) { mutableListOf() }.add(sourceValue)
            targetsByGroup.computeIfAbsent(group) { mutableListOf() }.add(targetValue)
        }

        var answer = 0
        for (key in sourcesByGroup.keys) {
            val sources = sourcesByGroup[key] ?: emptySet()
            val targets = targetsByGroup[key] ?: emptySet()
            
            val sourceCounts = mutableMapOf<Int, Int>()
            for (sourceValue in sources) {
                sourceCounts[sourceValue] = (sourceCounts[sourceValue] ?: 0) + 1
            }

            val targetCounts = mutableMapOf<Int, Int>()
            for (targetValue in targets) {
                targetCounts[targetValue] = (targetCounts[targetValue] ?: 0) + 1
            }
            
            for (sourceValue in sources.toSet()) {
                val diff = (sourceCounts[sourceValue] ?: 0) - (targetCounts[sourceValue] ?: 0)
                answer += max(0, diff)
            }
        }

        return answer
    }
}
