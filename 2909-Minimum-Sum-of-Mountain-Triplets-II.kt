import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun minimumSum(nums: IntArray): Int {
        val lefts = sortedSetOf<Int>()

        val rights = sortedSetOf<Int>()
        val rightCounts = mutableMapOf<Int, Int>()

        for (num in nums) {
            rights.add(num)
            rightCounts[num] = rightCounts.getOrDefault(num, 0) + 1
        }

        var ans = Int.MAX_VALUE

        for (num in nums) {
            if (rightCounts[num] == 1) {
                rights.remove(num)
            }
            rightCounts[num] = rightCounts.getOrDefault(num, 0) - 1

            val leftFound = lefts.higher(0) ?: -1
            val rightFound = rights.higher(0) ?: -1

            if (leftFound != -1 && rightFound != -1 && leftFound < num && num > rightFound) {
                ans = min(ans, leftFound + rightFound + num)
            }

            lefts.add(num)
        }

        return if (ans != Int.MAX_VALUE) {
            ans
        } else {
            -1
        }
    }
}
