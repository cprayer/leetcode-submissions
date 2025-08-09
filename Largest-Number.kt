class Solution {
    fun largestNumber(nums: IntArray): String {
        val sortedNums = nums.sortedWith { left, right ->
            val leftString = left.toString()
            val rightString = right.toString()

            val leftFirstResult = (leftString + rightString).toBigInteger()
            val rightFirstResult = (rightString + leftString).toBigInteger()
            if (leftFirstResult > rightFirstResult) {
                return@sortedWith -1
            } else if (leftFirstResult < rightFirstResult) {
                return@sortedWith 1
            } else {
                return@sortedWith 0
            }
        }

        if (sortedNums.size == sortedNums.count { it == 0 }) {
            return "0"
        } else {
            return sortedNums.joinToString("")
        }
    }
}
