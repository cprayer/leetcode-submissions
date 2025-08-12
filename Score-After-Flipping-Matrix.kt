import java.lang.Integer.max

class Solution {
    fun matrixScore(grid: Array<IntArray>): Int {
        val h = grid.size
        val w = grid[0].size
        
        var answer = getOptimal(grid)
        for (i in 0 until h) {
            grid[i][0] = 1 - grid[i][0]
        }
        return max(answer, getOptimal(grid))
    }

    private fun getOptimal(grid: Array<IntArray>): Int {
        val h = grid.size
        val w = grid[0].size

        for (i in 0 until h) {
            if (grid[i][0] == 0) {
                for (j in 0 until w) {
                    grid[i][j] = 1 - grid[i][j]
                }
            }
        }

        var answer = h
        for (i in 1 until w) {
            var count = 0
            for (j in 0 until h) {
                if (grid[j][i] == 1) count += 1
            }
            answer *= 2
            answer += max(count, h - count)
        }

        return answer
    }
}
