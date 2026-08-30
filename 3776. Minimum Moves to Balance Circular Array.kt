import java.lang.Integer.min
import kotlin.math.abs

class Solution {
    fun minMoves(balance: IntArray): Long {
        val t = balance.indexOfFirst { it < 0 }
        if (t < 0) {
            return 0
        }

        val size = balance.size
        var ans = 0L
        for (i in 1..size) {
            val leftIndex = (t - i + size) % size
            val rightIndex = (t + i) % size

            val leftV = balance[leftIndex]
            val leftResult = min(leftV, abs(balance[t]))
            balance[leftIndex] -= leftResult
            balance[t] += leftResult
            ans += leftResult.toLong() * i

            val rightV = balance[rightIndex]
            val rightResult = min(rightV, abs(balance[t]))
            balance[rightIndex] -= rightResult
            balance[t] += rightResult
            ans += rightResult.toLong() * i
        }

        if (balance[t] < 0) {
            return -1
        }

        return ans
    }
}
