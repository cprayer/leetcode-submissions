import java.lang.Long.max

class Solution {
    fun findMaximumNumber(k: Long, x: Int): Long {
        fun calculate(current: Long): Long {
            var sum = 0L
            var bit = (1L).shl(x)

            while (true) {
                if (current * 2 < bit) {
                    return sum
                }

                sum += (current / bit) * (bit / 2) + max(((current % bit) + 1 - bit / 2), 0L)
                bit = bit.shl(x)
            }
        }

        var left = 0L
        var right = MAX

        while (left + 1 < right) {
            val mid = (left + right) / 2
            val calculate = calculate(mid)
            if (calculate > k) {
                right = mid
            } else {
                left = mid
            }
        }

        return left
    }

    companion object {
        const val MAX = 1_000_000_000_000_000L
    }
}
