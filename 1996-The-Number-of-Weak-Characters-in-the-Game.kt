class Solution {
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        properties.sortWith { o1, o2 ->
            if (o1[0] != o2[0]) {
                o1[0] - o2[0]
            } else {
                o1[1] - o2[1]
            }
        }

        var ans = 0
        val defenseCounts = TreeMap<Int, Int>()
        for ((_, defense) in properties) {
            defenseCounts[defense] = (defenseCounts[defense] ?: 0) + 1
        }

        var removedIndex = 0
        for (i in properties.indices) {
            val (attack, defense) = properties[i]

            while (removedIndex < properties.size && properties[removedIndex][0] <= attack) {
                val current = properties[removedIndex][1]
                val count = defenseCounts.getOrDefault(current, 0)
                if (count == 1) {
                    defenseCounts.remove(current)
                } else if (count > 0) {
                    defenseCounts[current] = count - 1
                }
                removedIndex += 1
            }

            if (defenseCounts.higherKey(defense) != null) {
                ans += 1
            }
        }

        return ans
    }
}
