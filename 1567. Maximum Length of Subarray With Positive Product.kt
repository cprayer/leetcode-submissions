import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun getMaxLen(nums: IntArray): Int {
        var mostLeft = nums.size * 2
        var mostRight = -nums.size * 2
        var minusCount = 0
        var plusCount = 0
        var startIndex = 0

        var ans = 0
        for ((index, num) in (nums.toMutableList() + 0).withIndex()) {
            if (num == 0) {

                if (minusCount % 2 == 0) {
                    ans = max(ans, minusCount + plusCount)
                } else {
                    ans = max(ans, mostRight - startIndex)
                    ans = max(ans, index - 1 - mostLeft)
                }
                
                mostLeft = nums.size * 2
                mostRight = -nums.size * 2
                minusCount = 0
                plusCount = 0
                startIndex = index + 1
            } else {
                if (num > 0) {
                    plusCount += 1
                } else {
                    mostLeft = min(mostLeft, index)
                    mostRight = max(mostRight, index)
                    minusCount += 1
                }
            }
        }

        return ans
    }
}
