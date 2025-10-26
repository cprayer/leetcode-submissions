import java.lang.Integer.max

class Solution {
    fun lengthOfLongestSubsequence(nums: List<Int>, target: Int): Int {
        val dp = Array(1009) { IntArray(1009) { -1 } }
        val answer = getAnswer(dp, 0, target, nums)
        return if (answer != INF) {
            answer
        } else {
            -1
        }
    }

    fun getAnswer(dp: Array<IntArray>, current: Int, target: Int, nums: List<Int>): Int {
        if (target < 0) {
            return INF
        }
        if (current == nums.size) {
            return if (target == 0) {
                0
            } else {
                INF
            }
        }
        if (dp[current][target] != -1) {
            return dp[current][target]
        }

        dp[current][target] = INF
        val nonSelectedResult = getAnswer(dp, current + 1, target, nums)
        if (nonSelectedResult != INF) {
            dp[current][target] = max(dp[current][target], nonSelectedResult)
        }

        val selectedResult = getAnswer(dp, current + 1, target - nums[current], nums)
        if (selectedResult != INF) {
            dp[current][target] = max(dp[current][target], selectedResult + 1)
        }
        return dp[current][target]
    }

    companion object {
        const val INF = -1_000_000_009
    }
}
