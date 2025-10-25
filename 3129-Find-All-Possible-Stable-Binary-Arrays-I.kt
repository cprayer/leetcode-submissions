class Solution {

    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val dp = Array(zero + 1) {
            Array(one + 1) {
                Array(2) {
                    IntArray(limit + 1) { -1 }
                }
            }
        }
        return (getAnswer(dp, zero - 1, one, 0, 1, limit) + getAnswer(dp, zero, one - 1, 1, 1, limit)) % MODULO
    }

    fun getAnswer(dp: Array<Array<Array<IntArray>>>, i: Int, j: Int, current: Int, k: Int, limit: Int): Int {
        if (k > limit) {
            return 0
        }
        if (i < 0) {
            return 0
        }
        if (j < 0) {
            return 0
        }
        if (i == 0 && j == 0) {
            return 1
        }
        if (dp[i][j][current][k] != -1) {
            return dp[i][j][current][k]
        }
        dp[i][j][current][k] = when (current) {
            0 -> getAnswer(dp, i - 1, j, 0, k + 1, limit) + getAnswer(dp, i, j - 1, 1, 1, limit)
            else -> getAnswer(dp, i - 1, j, 0, 1, limit) + getAnswer(dp, i, j - 1, 1, k + 1, limit)
        } % MODULO
        return dp[i][j][current][k]
    }

    companion object {
        const val MODULO = 1_000_000_007
    }
}

