import java.util.*

class Solution {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        val indexes = TreeMap<Int, Int>()

        for ((index, interval) in intervals.withIndex()) {
            val (s, _) = interval

            if (indexes.contains(s)) {
                continue
            }

            indexes[s] = index
        }

        val answer = mutableListOf<Int>()

        for ((_, e) in intervals) {
            val found = indexes.ceilingKey(e)
            if (found != null) {
                answer.add(indexes.getValue(found))
            } else {
                answer.add(-1)
            }
        }

        return answer.toIntArray()
    }
}
