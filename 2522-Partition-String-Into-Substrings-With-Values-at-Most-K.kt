class Solution {
    fun minimumPartition(s: String, k: Int): Int {
        val dp = IntArray(s.length + 1) { MAX_VALUE }
        dp[s.length] = 0
        for (i in s.length - 1 downTo 0) {
            var current = 0L
            for (j in 0 until 10) {
                if (i + j >= s.length) {
                    continue
                }
                current += (s[i + j] - '0')
                if (current > k) {
                    break
                }
                dp[i] = Math.min(dp[i], 1 + dp[i + j + 1])
                current *= 10
            }
        }

        return if (dp[0] >= MAX_VALUE) {
            -1
        } else {
            dp[0]
        }
    }

    companion object {
        const val MAX_VALUE = 987_654_321
    }
}
