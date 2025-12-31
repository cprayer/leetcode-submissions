class Solution {
    fun partitionArray(nums: IntArray, k: Int): Boolean {
        if (nums.size % k != 0) {
            return false
        }

        val groupSize = nums.size / k
        val numsByNum = nums.groupBy { it }
        val maxValueCount = numsByNum.values.maxOf { it.count() }
        if (groupSize < maxValueCount) {
            return false
        }

        return true
    }
}
