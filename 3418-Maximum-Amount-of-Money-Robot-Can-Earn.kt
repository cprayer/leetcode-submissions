import java.lang.Integer.max

class Solution {
    fun maximumAmount(coins: Array<IntArray>): Int {
        val m = coins.size
        val n = coins[0].size

        val dp = Array(m) { Array(n) { IntArray(3) { INF } } }

        fun getAnswer(dp: Array<Array<IntArray>>, y: Int, x: Int, neutralize: Int): Int {
            if (y >= m || y < 0) {
                return MIN
            }
            if (x >= n || x < 0) {
                return MIN
            }
            if (neutralize < 0) {
                return MIN
            }
            if (y == m - 1 && x == n - 1) {
                return if (neutralize > 0) {
                    max(0, coins[y][x])
                } else {
                    coins[y][x]
                }
            }
            if (dp[y][x][neutralize] != INF) {
                return dp[y][x][neutralize]
            }
            dp[y][x][neutralize] = MIN
            if (coins[y][x] < 0) {
                dp[y][x][neutralize] = max(dp[y][x][neutralize], max(getAnswer(dp, y + 1, x, neutralize - 1), getAnswer(dp, y, x + 1, neutralize - 1)))
            }
            dp[y][x][neutralize] = max(dp[y][x][neutralize], coins[y][x] + max(getAnswer(dp, y + 1, x, neutralize), getAnswer(dp, y, x + 1, neutralize)))
            return dp[y][x][neutralize]
        }

        return getAnswer(dp, 0, 0, 2)
    }

    companion object {
        const val INF = 987654321
        const val MIN = -987654321
    }
}
