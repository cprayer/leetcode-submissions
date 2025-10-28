import java.lang.Integer.max

class Solution {
    fun longestEqualSubarray(nums: List<Int>, k: Int): Int {
        val positionsByNum = mutableMapOf<Int, MutableList<Int>>()
        for ((i, num) in nums.withIndex()) {
            positionsByNum.computeIfAbsent(num) { mutableListOf() }.add(i)
        }

        var answer = 0
        for((num, positions) in positionsByNum) {
            var leftIndex = 0
            for (rightIndex in positions.indices) {
                while(positions[rightIndex] - positions[leftIndex] - (rightIndex - leftIndex) > k) {
                    leftIndex += 1
                }
                answer = max(answer, rightIndex + 1 - leftIndex)
            }
        }

        return answer
    }
}
