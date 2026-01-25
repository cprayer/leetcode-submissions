class Solution {
    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        val bigIntegers = nums.map { it.toBigInteger() }.sortedDescending()
        return bigIntegers[k - 1].toString()
    }
}
