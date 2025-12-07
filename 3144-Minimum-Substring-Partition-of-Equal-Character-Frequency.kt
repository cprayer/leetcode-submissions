import java.lang.Integer.min

class Solution {
    fun getAnswer(dp: IntArray, s: String, current: Int): Int {
        if (current >= s.length) {
            return 0
        }
        if (dp[current] != -1) {
            return dp[current]
        }
        dp[current] = s.length

        val counts = IntArray(26) { 0 }
        for (i in current until s.length) {
            counts[s[i] - 'a'] += 1
            if (counts.filter { it != 0 }.none { it != counts[s[i] - 'a'] }) {
                dp[current] = min(dp[current], 1 + getAnswer(dp, s, i + 1))
            }
        }
        return dp[current]
    }

    fun minimumSubstringsInPartition(s: String): Int {
        val dp = IntArray(s.length) { -1 }
        return getAnswer(dp, s, 0)
    }
}
