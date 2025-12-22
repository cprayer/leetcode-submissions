import java.lang.Integer.min

class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size

        val answer = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            val coords = mutableListOf<Pair<Int, Int>>()
            val values = mutableListOf<Int>()
            for (j in 0..i) {
                val y = m - 1 - i + j
                val x = j

                if(x < 0 || x >= n) {
                    break
                }

                if (y < 0 || y >= m) {
                    break
                }

                coords.add(y to x)
                values.add(mat[y][x])
            }

            values.sort()

            for ((index, coord) in coords.withIndex()) {
                val (y, x) = coord
                answer[y][x] = values[index]
            }
        }

        for (i in 1 until n) {
            val coords = mutableListOf<Pair<Int, Int>>()
            val values = mutableListOf<Int>()
            for (j in 0 until m) {
                val y = j
                val x = i + j

                if (x < 0 || x >= n) {
                    break
                }
                if (y < 0 || y >= m) {
                    break
                }

                coords.add(y to x)
                values.add(mat[y][x])
            }

            values.sort()

            for ((index, coord) in coords.withIndex()) {
                val (y, x) = coord
                answer[y][x] = values[index]
            }
        }

        return answer
    }
}
