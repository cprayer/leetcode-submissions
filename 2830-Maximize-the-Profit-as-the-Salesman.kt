import java.lang.Integer.max

class Solution {
    fun maximizeTheProfit(n: Int, offers: List<List<Int>>): Int {
        val sortedOffersByEnd = offers.sortedBy { it[1] }
        val dp = Array(n) { 0 }
        var offerIndex = 0
        for (i in 0 until n) {
            dp[i] = max(dp[i], dp.getOrNull(i - 1) ?: 0)
            while (offerIndex < sortedOffersByEnd.size) {
                val (start, end, gold) = sortedOffersByEnd[offerIndex]
                if (end > i) {
                    break
                }
                val current = (dp.getOrNull(start - 1) ?: 0) + gold
                dp[i] = max(dp[i], current)
                offerIndex += 1
            }
        }
        return dp[n - 1]
    }
}
