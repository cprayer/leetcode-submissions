class Solution {
    fun minOperations(nums: IntArray, target: IntArray): Int {
        val answer = mutableSetOf<Int>()
        for (i in nums.indices) {
            if (nums[i] != target[i]) {
                answer.add(nums[i])
            }
        }
        return answer.size
    }
}
