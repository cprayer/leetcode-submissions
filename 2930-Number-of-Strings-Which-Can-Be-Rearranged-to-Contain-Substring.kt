import java.lang.Integer.min

class Solution {
    fun stringCount(n: Int): Int {
        val dp = Array(n + 1) { Array(2) { Array(3) { IntArray(2) { -1 } } } }

        fun getAnswer(current: Int, lCount: Int, eCount: Int, tCount: Int): Int {
            if (current == n) {
                return if (lCount == 1 && eCount == 2 && tCount == 1) {
                    1
                } else {
                    0
                }
            }

            if (dp[current][lCount][eCount][tCount] != -1) {
                return dp[current][lCount][eCount][tCount]
            }

            var result = 0
            for (i in 0 until 26) {
                result += when ('a' + i) {
                    'l' -> getAnswer(current + 1, min(1, lCount + 1), eCount, tCount)
                    'e' -> getAnswer(current + 1, lCount, min(2, eCount + 1), tCount)
                    't' -> getAnswer(current + 1, lCount, eCount, min(1, tCount + 1))
                    else -> getAnswer(current + 1, lCount, eCount, tCount)
                }
                result %= MOD
            }

            dp[current][lCount][eCount][tCount] = result
            return result
        }

        return getAnswer(0, 0, 0, 0)
    }

    companion object {
        const val MOD = 1_000_000_007
    }
}
