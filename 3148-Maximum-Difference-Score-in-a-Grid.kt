import java.lang.Integer.max
import kotlin.math.min

class Solution {
    fun maxScore(grid: List<List<Int>>): Int {
        val m = grid.size
        val n = grid[0].size
        val minValues = Array(m + 1) { IntArray(n + 1) { 987_654_321 } }

        var answer = Int.MIN_VALUE
        for (i in 1..m) {
            for (j in 1..n) {
                val current = grid[i - 1][j - 1]
                answer = max(answer, current - min(minValues[i - 1][j], minValues[i][j - 1]))
                minValues[i][j] = min(minValues[i - 1][j], min(minValues[i][j - 1], current))
            }
        }

        return answer
    }
}
