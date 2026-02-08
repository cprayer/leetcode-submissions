class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var write = 0
        for (x in nums) {
            if (write < 2 || nums[write - 2] != x) {
                nums[write++] = x
            }
        }
        return write
    }
}
