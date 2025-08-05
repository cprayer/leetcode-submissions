class Solution {
    fun assignElements(groups: IntArray, elements: IntArray): IntArray {
        val maxGroupValue = groups.max()
        val firstSeenIndexes = mutableMapOf<Int, Int>()
        for ((index, element) in elements.withIndex()) {
            if (firstSeenIndexes.contains(element)) {
                continue
            }
            firstSeenIndexes[element] = index
        }

        val valueIndexes = mutableMapOf<Int, MutableList<Int>>()
        for ((index, group) in groups.withIndex()) {
            valueIndexes.computeIfAbsent(group) { mutableListOf() }.add(index)
        }

        val answer = Array(groups.size) { -1 }
        firstSeenIndexes.forEach { (element, index) ->
            for (i in element..maxGroupValue step element) {
                for (valueIndex in valueIndexes[i] ?: emptyList()) {
                    if (answer[valueIndex] == -1) {
                        answer[valueIndex] = index
                    }
                }
            }
        }
        
        return answer.toIntArray()
    }
}
