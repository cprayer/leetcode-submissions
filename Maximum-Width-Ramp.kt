import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun maxWidthRamp(nums: IntArray): Int {
        val leftMins = mutableMapOf<Int, Int>()
        val rightMaxs = mutableMapOf<Int, Int>()

        for ((index, num) in nums.withIndex()) {
            leftMins[num] = min(leftMins[num] ?: index, index)
            rightMaxs[num] = max(rightMaxs[num] ?: index, index)
        }

        val descendingUniqueNums = nums.distinct().sortedDescending()
        var answer = 0
        var currentRightMax = -1
        for (num in descendingUniqueNums) {
            currentRightMax = max(currentRightMax, rightMaxs[num] ?: Int.MIN_VALUE)
            answer = max(answer, currentRightMax - (leftMins[num] ?: Int.MAX_VALUE))
        }

        return answer
    }
}
