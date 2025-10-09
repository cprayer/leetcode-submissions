import java.lang.Long.max
import kotlin.math.abs

class Solution {
    fun minOperations(nums1: IntArray, nums2: IntArray, k: Int): Long {
        if (nums1.sumOf { it.toLong() } != nums2.sumOf { it.toLong() }) {
            return -1
        }
        if (k == 0) {
            for (i in nums1.indices) {
                if (nums1[i] != nums2[i]) {
                    return -1
                }
            }
            return 0
        }

        var count = 0L
        for (i in nums1.indices) {
            val v = nums1[i] - nums2[i]
            val absV = abs(v)
            if (absV % k != 0) {
                return -1
            }

            count += absV / k
        }

        return count / 2L
    }
}
