class Solution {
    fun waysToSplitArray(nums: IntArray): Int {
        var leftSum = 0L
        var rightSum = nums.sumOf { it.toLong() }

        var answer = 0
        for (i in 0 until nums.size - 1) {
            leftSum += nums[i]
            rightSum -= nums[i]
            if (leftSum >= rightSum) {
                answer += 1
            }
        }
        return answer
    }
}
