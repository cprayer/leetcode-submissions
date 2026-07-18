class Solution {
    fun findCommonResponse(responses: List<List<String>>): String {
        val counts = mutableMapOf<String, Int>()
        for (response in responses) {
            for (item in response.toSet()) {
                counts[item] = (counts[item] ?: 0) + 1
            }
        }
        
        val maxValue = counts.maxOf { it.value }
        return counts.filterValues { value -> value == maxValue }.keys.toSortedSet().first()
    }
}
