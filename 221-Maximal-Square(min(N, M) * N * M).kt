import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val height = matrix.size
        val width = matrix[0].size
        val dp = Array(height + 1) { IntArray(width + 1) }

        var ans = 0
        for (i in 1..height) {
            for (j in 1..width) {
                if (matrix[i - 1][j - 1] == '0') {
                    continue
                }
                dp[i][j] = min(min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1
                ans = max(ans, dp[i][j] * dp[i][j])
            }
        }

        return ans
    }
}
