import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun maxRemovals(source: String, pattern: String, targetIndices: IntArray): Int {
        val sourceLength = source.length
        val patternLength = pattern.length
        val dp = Array(sourceLength) { Array(patternLength) { UNSET } }
        val targetIndicesSet = targetIndices.toSortedSet()

        fun getAnswer(currentIndex: Int, patternIndex: Int): Int {
            if (patternIndex >= patternLength) {
                return targetIndicesSet.tailSet(currentIndex).size
            }
            if (currentIndex == sourceLength) {
                return MINUS_INF
            }

            var v = dp[currentIndex][patternIndex]
            if (v != UNSET) {
                return v
            }
            if (targetIndicesSet.contains(currentIndex)) {
                v = max(v, 1 + getAnswer(currentIndex + 1, patternIndex))
            }
            v = if (source[currentIndex] == pattern[patternIndex]) {
                max(v, getAnswer(currentIndex + 1, patternIndex + 1))
            } else {
                max(v, getAnswer(currentIndex + 1, patternIndex))
            }

            dp[currentIndex][patternIndex] = v
            return v
        }

        return getAnswer(0, 0)
    }


    companion object {
        const val MINUS_INF = -1_000_000
        const val UNSET = -987_654_321
    }

}
