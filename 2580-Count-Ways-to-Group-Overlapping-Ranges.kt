import java.lang.Integer.max

class Solution {
    fun countWays(ranges: Array<IntArray>): Int {
        ranges.sortWith { left, right ->
            val (leftStart, leftEnd) = left
            val (rightStart, rightEnd) = right
            if (leftStart != rightStart) {
                leftStart - rightStart
            } else {
                leftEnd - rightEnd
            }
        }

        var answer = 1
        var l = 0
        while (l < ranges.size) {
            var r = l
            var currentEnd = ranges[l][1]
            while (r < ranges.size && ranges[r][0] <= currentEnd) {
                currentEnd = max(currentEnd, ranges[r][1])
                r += 1
            }

            l = r
            answer *= 2
            answer %= MOD
        }

        return answer
    }

    companion object {
        const val MOD = 1_000_000_007
    }
}
