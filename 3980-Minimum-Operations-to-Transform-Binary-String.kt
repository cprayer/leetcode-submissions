import java.lang.Integer.min

class Solution {
    fun minOperations(s1: String, s2: String): Int {

        val size = s1.length
        val dp = Array(size) { IntArray(2) { -1 } }

        fun getAnswer(current: Int, isZero: Int): Int {
            if (current == size) {
                return 0
            }
            if (current > size) {
                return MAX_VALUE
            }
            if (dp[current][isZero] != -1) {
                return dp[current][isZero]
            }

            var minCost = MAX_VALUE

            val ch = if (isZero == 1) {
                '0'
            } else {
                s1[current]
            }

            if (ch == '0') {
                val additionalCost = if (s2[current] == ch) 0 else 1
                minCost = min(minCost, getAnswer(current + 1, 0) + additionalCost)
                if (current + 1 < size && s1[current + 1] == '1') {
                    minCost = min(minCost, getAnswer(current + 1, 1) + 2 + additionalCost)
                }
            } else { // ch == '1'
                if (s2[current] == ch) { // s2[current] = '1'
                    minCost = min(minCost, getAnswer(current + 1, 0))
                    if (current + 1 < size && s1[current + 1] == '1') {
                        minCost = min(minCost, getAnswer(current + 1, 1) + 2)
                    }
                } else if (current + 1 < size) { // s2[current] = '0',
                    minCost = min(minCost, getAnswer(current + 1, 1) + 1 + if (s1[current + 1] == '1') 0 else 1)
                }
            }
            dp[current][isZero] = minCost
            return minCost
        }

        val ans = getAnswer(0, 0)
        return if (ans >= MAX_VALUE) {
            -1
        } else {
            ans
        }
    }

    companion object {
        const val MAX_VALUE = 987_654_321
    }
}
