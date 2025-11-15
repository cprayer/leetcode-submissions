class Solution {
    fun uniquePaths(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { Array(n) { IntArray(2) { -1 } } }

        fun getAnswer(y: Int, x: Int, d: Int): Int {
            if (y >= m || y < 0) {
                return 0
            }
            if (x >= n || x < 0) {
                return 0
            }
            if (y == m - 1 && x == n - 1) {
                return 1
            }
            if (dp[y][x][d] != -1) {
                return dp[y][x][d]
            }

            when (grid[y][x]) {
                0 -> {
                    dp[y][x][d] = getAnswer(y + 1, x, 0) + getAnswer(y, x + 1, 1)
                    dp[y][x][d] %= MOD
                }
                1 -> {
                    when (d) {
                        0 -> {
                            dp[y][x][d] = getAnswer(y, x + 1, 1)
                        }
                        1 -> {
                            dp[y][x][d] = getAnswer(y + 1, x, 0)
                        }
                    }
                }
            }
            return dp[y][x][d]
        }

        return getAnswer(0, 0, 0)
    }

    companion object {
        const val MOD = 1_000_000_007
    }
}
