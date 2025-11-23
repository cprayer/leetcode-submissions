import java.math.BigDecimal
import java.math.RoundingMode

class Solution {
    fun largestSumOfAverages(nums: IntArray, k: Int): Double {
        val dp = Array(nums.size) { Array(k) { 0.0 } }
        return getAnswer(nums, dp, 0, k - 1)
    }

    fun getAnswer(nums: IntArray, dp: Array<Array<Double>>, current: Int, k: Int): Double {
        if (current == dp.size) {
            return 0.0
        }
        if (dp[current][k] != 0.0) {
            return dp[current][k]
        }
        var count = 0
        var sum = 0
        var answer = 0.0
        for (i in current until nums.size) {
            val num = nums[i]
            sum += num
            count += 1
            if (k > 0) {
                answer = answer.coerceAtLeast(getAnswer(nums, dp, i + 1, k - 1) + sum.toDouble() / count)
            }
        }

        dp[current][k] = answer.coerceAtLeast(sum.toDouble() / count)
        return dp[current][k]
    }
}
