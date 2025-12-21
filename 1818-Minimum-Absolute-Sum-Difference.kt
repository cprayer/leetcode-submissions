import java.lang.Long.min
import java.util.*
import kotlin.math.abs

class Solution {
    fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val diffs = IntArray(n)

        for (i in 0 until n) {
            diffs[i] = abs(nums1[i] - nums2[i])
        }
        val sum = diffs.sumOf { it.toLong() }

        var answer = Long.MAX_VALUE
        val sortedNums1 = nums1.sorted()
        for (i in 0 until n) {
            var left = -1
            var right = n

            while (left + 1 < right) {
                val mid = (left + right) / 2
                if (sortedNums1[mid] >= nums2[i]) {
                    right = mid
                } else {
                    left = mid
                }
            }

            val leftClosest = (sortedNums1.getOrNull(right - 1) ?: Int.MAX_VALUE).toLong()
            val rightClosest = (sortedNums1.getOrNull(right) ?: Int.MAX_VALUE).toLong()
            val minDiff = min(abs(leftClosest - nums2[i]), abs(rightClosest - nums2[i]))

            answer = min(answer, sum - diffs[i] + minDiff)
        }

        return (answer % MOD).toInt()
    }

    companion object {
        const val MOD = 1_000_000_007
    }
}
