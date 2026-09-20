import java.lang.Integer.max

class Solution {
    fun maximumRows(matrix: Array<IntArray>, numSelect: Int): Int {
        val r = matrix.size
        val c = matrix[0].size

        fun calc(currentColumn: Int, selected: MutableSet<Int>): Int {
            if (selected.size == numSelect) {
                var count = 0
                for (i in 0 until r) {
                    var isPossible = true
                    for (j in 0 until c) {
                        if (matrix[i][j] == 1 && !selected.contains(j)) {
                            isPossible = false
                            break
                        }
                    }
                    count += if (isPossible) 1 else 0
                }
                return count
            }

            var ret = 0
            for (i in currentColumn until c) {
                selected.add(i)
                ret = max(ret, calc(i + 1, selected))
                selected.remove(i)
            }

            return ret
        }

        return calc(0, mutableSetOf())
    }

}
