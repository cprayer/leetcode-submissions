import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun minimumDeletions(nums: IntArray): Int {
        if (nums.size == 1) {
            return 1
        }

        val minIndex = nums.indexOf(nums.min())
        val maxIndex = nums.indexOf(nums.max())

        val leftIndex = min(minIndex, maxIndex)
        val rightIndex = max(minIndex, maxIndex)

        return min(min(1 + rightIndex, nums.size - leftIndex), 1 + leftIndex + nums.size - rightIndex)
    }
}
