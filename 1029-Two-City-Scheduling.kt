import java.lang.Integer.min

class Solution {

    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val n = costs.size / 2
        val dp = Array(n + 9) { IntArray(n + 9) { -1 } }

        fun getAnswer(a: Int, b: Int): Int {
            if (a > n) {
                return MAX_V
            }
            if (b > n) {
                return MAX_V
            }
            if (a == n && b == n) {
                return 0
            }
            if (dp[a][b] != -1) {
                return dp[a][b]
            }

            val current = a + b
            dp[a][b] = min(getAnswer(a + 1, b) + costs[current][0], getAnswer(a, b + 1) + costs[current][1])
            return dp[a][b]
        }

        return getAnswer(0, 0)
    }

    companion object {
        const val MAX_V = 987_654_321
    }
}
