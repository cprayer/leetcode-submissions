import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums.first()
        }

        val preSums = IntArray(nums.size)

        var answer = Int.MIN_VALUE
        var minSum = 0
        for (i in nums.indices) {
            preSums[i] += (preSums.getOrNull(i - 1) ?: 0) + nums[i]
            answer = max(answer, max(preSums[i], preSums[i] - minSum))
            minSum = min(minSum, preSums[i])
        }

        val minSums = IntArray(nums.size) { Int.MAX_VALUE }
        minSum = preSums.last()
        for (i in nums.indices.reversed()) {
            minSum = min(minSum, preSums[i])
            minSums[i] = minSum
        }

        var preSum = preSums.last()
        for (i in nums.indices) {
            preSum += nums[i]
            answer = max(answer, preSum - minSums[i])
        }

        return answer
    }
}
