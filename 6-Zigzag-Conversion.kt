import java.lang.Integer.max

class Solution {
    fun convert(s: String, numRows: Int): String {
        val rows = Array(numRows) { StringBuilder() }
        val d = max(0, numRows - 2)
        val unit = numRows + d
        for ((index, ch) in s.withIndex()) {
            val current = index % unit
            val row = if (current < numRows) {
                current
            } else {
                numRows - (current - numRows) - 2
            }

            rows[row].append(ch)
        }

        return rows.joinToString("") { it.toString() }
    }
}
