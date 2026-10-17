class Solution {
    fun numTrees(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1

        for (current in 1..n) {
            for (root in 1..current) {
                dp[current] += dp[root - 1] * dp[current - root]
            }
        }

        return dp[n]
    }
}
