import java.lang.Integer.max

class Solution {
    fun maxSubarrays(nums: IntArray): Int {
        var a = (2 shl 25) - 1
        var answer = 1
        for (num in nums) {
            if (a == 0) {
                answer += 1
                a = num
            }
            a = a and num
        }
        if (a != 0) {
            answer -= 1
        }

        return max(1, answer)
    }
}
