class Solution {
    fun minMoves(nums: IntArray): Int {
        val minNum = nums.min()
        return nums.map { it - minNum }.sum()
    }
}
