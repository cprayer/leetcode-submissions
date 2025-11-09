class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        var s = ""
        for (i in nums.indices) {
            s += when (nums[i][i]) {
                '0' -> '1'
                else -> '0'
            }
        }
        return s
    }
}
