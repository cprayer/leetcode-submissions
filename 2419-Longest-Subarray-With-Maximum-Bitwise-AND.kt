import java.lang.Integer.max

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val v = nums.max()
        var answer = 1
        var count = 0
        for (num in nums) {
            if (v == num) {
                count += 1
                answer = max(answer, count)
            } else {
                count = 0
            }
        }
        return answer
    }
}
