import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort()

        var currentMin = nums[0]
        var currentMax = nums[0]
        var answer = 1
        for (num in nums) {
            currentMin = min(currentMin, num)
            currentMax = max(currentMax, num)
            
            if (currentMax - currentMin > k) {
                answer += 1
                currentMin = num
                currentMax = num
            }
        }

        return answer
    }
}