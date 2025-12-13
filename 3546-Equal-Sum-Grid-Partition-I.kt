class Solution {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size

        val rowsSum = LongArray(m) { 0 }
        rowsSum[0] = grid[0].sumOf { it.toLong() }
        for (i in 1 until m) {
            rowsSum[i] += rowsSum[i - 1] + grid[i].sum()
        }

        for (i in 0 until m - 1) {
            if (rowsSum[i] == rowsSum[m - 1] - rowsSum[i]) {
                return true
            }
        }

        val colsSum = LongArray(n) { 0 }
        for (i in 0 until m) {
            colsSum[0] += grid[i][0]
        }
        for (i in 1 until n) {
            colsSum[i] += colsSum[i - 1]
            for (j in 0 until m) {
                colsSum[i] += grid[j][i]
            }
        }

        for (i in 0 until n - 1) {
            if (colsSum[i] == colsSum[n - 1] - colsSum[i]) {
                return true
            }
        }

        return false
    }
}
