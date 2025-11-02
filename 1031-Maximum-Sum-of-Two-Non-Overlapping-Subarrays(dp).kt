import java.lang.Integer.max

class Solution {
    fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        val length = nums.size

        val prefixSums = Array(length + 9) { 0 }
        for (i in nums.indices) {
            prefixSums[i + 1] += prefixSums[i] + nums[i]
        }

        var ans = 0

        val dp1 = Array(length + 9) { 0 }
        val dp2 = Array(length + 9) { 0 }

        for (i in length - firstLen + 1 downTo 1) {
            dp1[i] = max(dp1[i + 1], prefixSums[i + firstLen - 1] - prefixSums[i - 1])
        }

        for (i in length - secondLen + 1 downTo 1) {
            dp2[i] = max(dp2[i + 1], prefixSums[i + secondLen - 1] - prefixSums[i - 1])
        }

        for (i in firstLen.. length) {
            ans = max(ans, prefixSums[i] - prefixSums[i - firstLen] + dp2[i + 1])
        }

        for (i in secondLen.. length) {
            ans = max(ans, prefixSums[i] - prefixSums[i - secondLen] + dp1[i + 1])
        }

        return ans
    }
}
