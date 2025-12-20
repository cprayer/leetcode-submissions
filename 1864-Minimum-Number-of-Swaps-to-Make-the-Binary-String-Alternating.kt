import java.lang.Integer.min
import kotlin.math.abs

class Solution {
    fun minSwaps(s: String): Int {
        val oneCount = s.count { it == '1' }
        val zeroCount = s.count { it == '0' }
        if (s.length % 2 == 0) {
            return if (oneCount != zeroCount) {
                -1
            } else {
                min(calculate(s, false), calculate(s, true))
            }

        } else {
            return if (abs(oneCount - zeroCount) != 1) {
                -1
            } else {
                if (oneCount > zeroCount) {
                    calculate(s, false)
                } else {
                    calculate(s, true)
                }
            }
        }
    }

    private fun calculate(s: String, isZeroCount: Boolean): Int {
        var swapCount = 0
        for (i in s.indices step 2) {
            if (isZeroCount && s[i] == '1') {
                swapCount += 1
            } else if (!isZeroCount && s[i] == '0') {
                swapCount += 1
            }
        }
        return swapCount
    }
}
