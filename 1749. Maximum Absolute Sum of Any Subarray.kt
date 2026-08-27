import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.math.abs

class Solution {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var minV = 0
        var maxV = 0
        var ans = 0
        var sum = 0
        for (num in nums) {
            sum += num

            ans = max(ans, abs(sum - minV))
            ans = max(ans, abs(sum - maxV))

            minV = min(minV, sum)
            maxV = max(maxV, sum)
        }

        return ans
    }
}
