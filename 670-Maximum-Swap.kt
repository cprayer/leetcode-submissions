import java.lang.Integer.max

class Solution {
    fun maximumSwap(num: Int): Int {
        val numString = num.toString()
        var ans = num
        for (i in numString.indices) {
            for (j in i + 1 until numString.length) {
                val iCh = numString[i]
                val jCh = numString[j]
                val current = numString.substring(0, i) + jCh + numString.substring(i + 1, j) + iCh + numString.substring(j + 1)
                ans = max(ans, current.toInt())
            }
        }
        return ans
    }
}
