import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
        val numsSize = nums.size
        val maxNumByRange = Array(numsSize) { IntArray(numsSize) }
        for (i in 0 until numsSize) {
            var maxNum = nums[i]
            for (j in i until numsSize) {
                maxNum = max(maxNum, nums[j])
                maxNumByRange[i][j] = maxNum
            }
        }

        val preSums = IntArray(numsSize)
        var sum = 0
        for (i in 0 until numsSize) {
            sum += nums[i]
            preSums[i] += sum
        }

        val dp = Array(numsSize) { IntArray(k + 1) { -1 } }

        fun getAnswer(current: Int, remain: Int): Int {
            if (current >= numsSize) {
                return 0
            }
            if (remain == 0) {
                return maxNumByRange[current][nums.size - 1] * (nums.size - current) - (preSums[nums.size - 1] - (preSums.getOrNull(current - 1) ?: 0))
            }
            if (dp[current][remain] != -1) {
                return dp[current][remain]
            }

            var minTotalCost = Int.MAX_VALUE
            for (i in current until nums.size) {
                val blockCost = maxNumByRange[current][i] * (i - current + 1) - (preSums[i] - (preSums.getOrNull(current - 1) ?: 0))
                minTotalCost = min(minTotalCost, getAnswer(i + 1, remain - 1) + blockCost)
            }

            dp[current][remain] = minTotalCost
            return minTotalCost
        }

        return getAnswer(0, k)
    }
}
