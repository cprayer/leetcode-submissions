import java.lang.Integer.max

class Solution {
    fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        val length = nums.size

        val prefixSums = Array(length + 1) { 0 }
        for (i in nums.indices) {
            prefixSums[i + 1] += prefixSums[i] + nums[i]
        }

        var ans = 0

        for (i in 0..length - firstLen) {
            for (j in i + firstLen..length - secondLen) {
                val sum1 = prefixSums[i + firstLen] - prefixSums[i]
                val sum2 = prefixSums[j + secondLen] - prefixSums[j]
                ans = max(ans, sum1 + sum2)
            }
        }

        for (i in 0..length - secondLen) {
            for (j in i + secondLen..length - firstLen) {
                val sum2 = prefixSums[i + secondLen] - prefixSums[i]
                val sum1 = prefixSums[j + firstLen] - prefixSums[j]
                ans = max(ans, sum1 + sum2)
            }
        }

        return ans
    }
}
