import java.lang.Long.max

class Solution {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val minSumByMod = mutableMapOf<Int, Long>()
        var sum = 0L
        var answer = Long.MIN_VALUE
        for ((index, num) in nums.withIndex()) {
            sum += num
            val mod = (index + 1) % k

            if (mod == 0) {
                answer = max(answer, sum)
            }

            minSumByMod[mod]?.let {
                answer = max(answer, sum - it)
            }

            if (minSumByMod.getOrDefault(mod, Long.MAX_VALUE) > sum) {
                minSumByMod[mod] = sum
            }
        }
        return answer
    }
}
