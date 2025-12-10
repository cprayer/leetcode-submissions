import java.lang.Integer.min

class Solution {
    fun minimumOperations(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(n) { IntArray(10) { 0 } }

        for (i in 0 until n) {
            for (j in 0 until m) {
                for (k in 0..9) {
                    val op = if (grid[j][i] != k) 1 else 0
                    dp[i][k] += op
                }
            }
            
            for (k in 0..9) {
                    var minV = Int.MAX_VALUE
                    for (l in 0..9) {
                        if (k == l) {
                            continue
                        }
                        val v = if (i - 1 >= 0) {
                            dp[i - 1][l]
                        } else {
                            0
                        }
                        minV = min(minV, v)
                    }
                    dp[i][k] += minV
                }
        }

        var answer = Int.MAX_VALUE
        for (i in 0..9) {
            answer = min(answer, dp[n - 1][i])
        }
        return answer
    }
}
