import java.lang.Integer.max

class Solution {
    fun longestArithSeqLength(nums: IntArray): Int {
        val diffs = Array(nums.size) { mutableMapOf<Int, Int>() }
        for (i in 0 until nums.size) {
            for(j in 0 until i) {
                val diff = nums[i] - nums[j]
                diffs[i][diff] = max(diffs[i].getOrDefault(diff, 0), diffs[j].getOrDefault(diff, 0) + 1)
            }
        }
        return diffs.maxOf { it.values.maxOrNull() ?: 0 } + 1
    }
}
