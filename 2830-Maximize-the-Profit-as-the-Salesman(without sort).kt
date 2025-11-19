import java.lang.Integer.max

class Solution {
    fun maximizeTheProfit(n: Int, offers: List<List<Int>>): Int {
        val offerItemsByEnd = Array(n) { mutableListOf<List<Int>>() }.apply { 
            for (offer in offers) {
                val (_, end, _) = offer
                this[end].add(offer)
            }
        }
        val dp = Array(n) { 0 }
        for (i in 0 until n) {
            dp[i] = max(dp[i], dp.getOrNull(i - 1) ?: 0)
            for (offer in offerItemsByEnd[i]) {
                val (start, end, gold) = offer
                val current = (dp.getOrNull(start - 1) ?: 0) + gold
                dp[i] = max(dp[i], current)
            }
        }
        return dp[n - 1]
    }
}
