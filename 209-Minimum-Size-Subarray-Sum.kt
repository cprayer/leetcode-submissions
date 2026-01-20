import java.lang.Integer.min

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.sum() < target) {
            return 0
        }

        var sum = 0
        var r = 0

        while (sum < target) {
            sum += nums[r]
            r += 1
        }

        var answer = r

        for (l in nums.indices) {
            sum -= nums[l]
            while (sum < target && r < nums.size) {
                sum += nums[r]
                r += 1
            }

            if (sum >= target) {
                answer = min(answer, r - l - 1)
            }
        }

        return answer
    }
}
