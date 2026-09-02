import java.lang.Integer.max

class Solution {
    fun maxProduct(nums: IntArray): Long {
        val dp = IntArray(1.shl(20))
        for (num in nums) {
            dp[num] = num
        }

        for (i in 0..19) {
            for (j in 0 until 1.shl(20)) {
                val bit = 1.shl(i)
                if (j.and(bit) == bit) {
                    dp[j] = max(dp[j], dp[j.xor(bit)])
                }
            }
        }

        var ans = 0L
        val other = 1.shl(20) - 1
        for (num in nums) {
            val and = num.xor(other)
            ans = Math.max(ans, num.toLong() * dp[and])
        }

        return ans
    }
}
