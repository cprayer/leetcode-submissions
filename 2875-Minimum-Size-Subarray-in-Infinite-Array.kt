import java.lang.Long.min

class Solution {
    fun minSizeSubarray(nums: IntArray, target: Int): Int {
        val size = nums.size
        val numsSum = nums.sumOf { it.toLong() }

        var acc = 0L
        var answer = Long.MAX_VALUE
        val indexesBySum = mutableMapOf<Long, Int>()
        for (i in 0 until size * 2) {
            acc += nums[i % size]
            indexesBySum[acc] = i

            val match = acc - target
            if (indexesBySum.contains(match)) {
                answer = min(answer, (i - indexesBySum.getValue(match)).toLong())
            }
            val matchCycle = acc - (target % numsSum)
            if (indexesBySum.contains(matchCycle)) {
                answer = min(answer, i - indexesBySum.getValue(matchCycle) + (target / numsSum) * size)
            }
        }
        return if (answer != Long.MAX_VALUE) {
            answer.toInt()
        } else {
            -1
        }
    }
}
