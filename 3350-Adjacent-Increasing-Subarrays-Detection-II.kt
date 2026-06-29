class Solution {
    fun maxIncreasingSubarrays(nums: List<Int>): Int {
        val lengths = IntArray(nums.size)
        lengths[nums.size - 1] = 1
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                lengths[i] = lengths[i + 1] + 1
            } else {
                lengths[i] = 1
            }
        }

        var ans = 0
        for (i in nums.indices) {
            val next = i + lengths[i]
            ans = Math.max(ans, lengths[i] / 2)
            if (next < nums.size) {
                ans = Math.max(ans, Math.min(lengths[i], lengths[next]))
            }
        }

        return ans
    }
}
