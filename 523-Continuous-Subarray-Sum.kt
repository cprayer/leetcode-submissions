class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val modMap = mutableMapOf<Int, Int>()
        modMap[0] = -1

        var sum = 0
        for (i in nums.indices) {
            val num = nums[i]
            sum += num

            val index = modMap.computeIfAbsent(sum % k) { i }
            if (i - index >= 2) {
                return true
            }
        }

        return false
    }
}
