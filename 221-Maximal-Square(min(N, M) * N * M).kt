import java.lang.Integer.min

class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val height = matrix.size
        val width = matrix[0].size
        val maximal = min(height, width)
        val dp = Array(maximal) { Array(height + 1) { IntArray(width + 1) } }

        var ans = 0
        for (i in 0 until height) {
            for (j in 0 until width) {
                dp[0][i][j] = when(matrix[i][j]) {
                    '1' -> 1
                    else -> 0
                }
                if (dp[0][i][j] == 1) {
                    ans = 1
                }
            }
        }

        for (m in 1 until maximal) {
            for (i in 0 until height) {
                for (j in 0 until width) {
                    val sum = dp[m - 1][i][j] + dp[m - 1][i][j + 1] + dp[m - 1][i + 1][j] + dp[m - 1][i + 1][j + 1]
                    dp[m][i][j] = if (sum == 4) {
                        1
                    } else {
                        0
                    }
                    if (dp[m][i][j] == 1) {
                        ans = (m + 1) * (m + 1)
                    }
                }
            }
        }
        
        return ans
    }
}
