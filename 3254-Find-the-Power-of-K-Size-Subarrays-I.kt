class Solution {
    fun resultsArray(nums: IntArray, k: Int): IntArray {

        var lastNum = 0
        var count = 0
        val answer = mutableListOf<Int>()
        for ((index, num) in nums.withIndex()) {
            if (lastNum + 1 != num) {
                count = 1
            } else {
                count += 1
            }
            lastNum = num

            if (index >= k - 1) {
                if (count >= k) {
                    answer.add(lastNum)
                } else {
                    answer.add(-1)
                }
            }
        }

        return answer.toIntArray()
    }
}
