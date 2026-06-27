class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith { o1, o2 ->
            if (o1[1] != o2[1]) {
                o1[1] - o2[1]
            } else {
                o1[0] - o2[0]
            }
        }

        var currentEnd = Int.MIN_VALUE
        var answer = 0
        for ((start, end) in intervals) {
            if (currentEnd <= start) {
                currentEnd = end
                answer += 1
            }
        }

        return intervals.size - answer
    }
}
