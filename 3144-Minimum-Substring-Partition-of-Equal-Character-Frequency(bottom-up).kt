import java.lang.Integer.min

class Solution {
    fun minimumSubstringsInPartition(s: String): Int {
        val n = s.length
        val dp = IntArray(n + 1) { n }
        dp[n] = 0

        for (i in n - 1 downTo 0) {
            val counts = IntArray(26) { 0 }

            for (j in i until n) {
                counts[s[j] - 'a'] += 1

                if (counts.filter { it != 0 }.none { it != counts[s[j] - 'a'] }) {
                    dp[i] = min(dp[i], 1 + dp[j + 1])
                }
            }
        }

        return dp[0]
    }
}
