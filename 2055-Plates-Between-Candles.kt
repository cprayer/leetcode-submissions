import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        val firstCandleIndex = s.indexOf('|')

        if (firstCandleIndex == -1) {
            return IntArray(queries.size)
        }

        val items = mutableListOf<Pair<Int, Int>>()
        items.add(firstCandleIndex to 0)

        var acc = 0
        var counts = 0
        for (i in firstCandleIndex + 1 until s.length) {
            if (s[i] == '|') {
                acc += counts
                counts = 0
                items.add(i to acc)
            } else {
                counts += 1
            }
        }
        items.add(s.length to acc)

        fun binarySearch(target: Int): Int {
            var l = -1
            var r = items.size

            while (l + 1 < r) {
                val m = (l + r) / 2
                if (items[m].first >= target) {
                    r = m
                } else {
                    l = m
                }
            }

            return min(r, items.size - 1)
        }

        val answer = mutableListOf<Int>()
        for ((left, right) in queries) {
            val rightIndex = max(0, binarySearch(right + 1) - 1)
            val leftIndex = binarySearch(left)

            answer.add(max(0, items[rightIndex].second - items[leftIndex].second))
        }

        return answer.toIntArray()
    }
}
